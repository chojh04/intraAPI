package kr.co.kpcard.billingservice.app.repository.settlement.popcard;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PopCardDealsSettlementMapper {

	public static final String INSERT_SQL = "<script>"
			                                         + "INSERT ALL                      "
			                                         + " <foreach collection='popCardSettlementList' item='data' index='index' separator='' close=''>"
			                                         + "  INTO SETTLE_POP_DEAL          "
	                                                 + "       VALUES                   "
	                                                 + "       (                        "
	                                                 + "         #{data.workDt         }"
	                                                 + "        ,(SELECT (NVL(MAX(TO_NUMBER(SEQ)), 0) + 1) + #{index} FROM SETTLE_POP_DEAL WHERE WORK_DT = #{data.workDt} ) "
	                                                 + "        ,#{data.dealDate       }"
	                                                 + "        ,#{data.orderNo        }"
	                                                 + "        ,#{data.approvalNo     }"
	                                                 + "        ,#{data.dealDivider    }"
	                                                 + "        ,#{data.cardNo         }"
	                                                 + "        ,#{data.useDate        }"
	                                                 + "        ,#{data.amount         }"
	                                                 + "        ,#{data.balance        }"
	                                                 + "        ,#{data.merchantCode   }"
	                                                 + "        ,#{data.merchantName   }"
	                                                 + "        ,#{data.onOffLineDivier}"
	                                                 + "        ,#{data.cardDivider    }"
	                                                 + "        ,SYSDATE    	        "                
	                                                 + "       )                        "	                                                 
	                                                 + " </foreach>"
	                                                 + "SELECT * FROM DUAL"
	                                                 + "</script> ";
	

	
	public static final String DELETE_SQL = ""
			+ "<script>                    "
			+ "DELETE FROM SETTLE_POP_DEAL WHERE WORK_DT = #{workDt} "
			+ "</script>";



	public static final String SELECT_SQL = ""
										  +"SELECT  A.apldate dealDate"
										  +"       ,A.aplorderno orderNo"
										  +"       ,A.aplno approvalNo"
										  +"       ,CASE WHEN KIND = 'charge' AND STATUS = 'TT1' THEN '0501'"
										  +"             WHEN KIND = 'charge' AND STATUS = 'TS1' THEN '0502'"
										  +"             WHEN KIND = 'charge' AND STATUS = 'GS1' THEN '0401'"
										  +"             WHEN KIND = 'charge' AND STATUS = 'GT1' THEN '0402'"
										  +"             WHEN KIND = 'charge' AND STATUS IN ('GS2','GS3') THEN '0403'"
										  +"             WHEN KIND = 'charge' THEN '0202'"
										  +"             WHEN KIND = 'payment' AND STATUS = 'O1' THEN '0301'"
										  +"             WHEN KIND = 'payment' AND STATUS = 'R1' THEN '0601'"
										  +"             WHEN KIND = 'payment' AND STATUS IN ('D1', 'D2') THEN '0302'"
										  +"             WHEN KIND = 'payment' AND STATUS = 'T1' THEN '0602'"
										  +"             WHEN KIND = 'happycash' AND STATUS = 'O1' THEN '0701'"
										  +"             WHEN KIND = 'refund' THEN '0801'"
										  +"             ELSE '9901'"
										  +"        END AS dealDivider"
										  +"       ,A.barcode_no cardNo"
										  +"       ,A.apldate || a.APLTIME useDate"
										  +"       ,A.amount"
										  +"       ,A.current_amt balance"
										  +"       ,A.aplonlineid merchantCode"
										  +"       ,A.aplonline_nm merchantName"
										  +"       ,CASE WHEN PAY_KIND IN ('MS') THEN 'ON'"
										  +"             ELSE 'OFF'"
										  +"         END  onOffLineDivier"
										  +"       ,CASE WHEN PAY_KIND IN ('MS') THEN '1'"
										  +"             WHEN PAY_KIND IN ('CS', 'CP') THEN '2'"
										  +"             ELSE '3'"
										  +"         END AS cardDivider"
										  +"  FROM   (SELECT  'charge' AS KIND"
										  +"                 ,TO_CHAR(APLDATE ,'YYYYMMDD') AS APLDATE"
										  +"                 ,TO_CHAR(APLDATE ,'hh24miss') AS APLTIME"
										  +"                 ,APLDATE AS INSERT_DT"
										  +"                 ,APLONLINEID"
										  +"                 ,DECODE(APLONLINEID, 'gspopcards', 'GS25 / ', 'gssmpops', 'GS수퍼 / ')|| "
										  +"                   NVL((SELECT CP_NAME"
										  +"                          FROM   KPC_APPROVAL.PG_CP D"
										  +"                          WHERE  D.SUBMERCHANT_CD = F.SUBMERCHANT_ID"
										  +"                          AND    A.BRANCHCODE = D.CP_ID ) , DECODE(F.NAME, '신용카드_POP', '신용/체크카드_POP', F.NAME)) AS APLONLINE_NM"
										  +"                 ,BARCODE_NO"
										  +"                 ,APLORDERNO"
										  +"                 ,APLNO"
										  +"                 ,APLSTATUS AS STATUS"
										  +"                 ,RC_AMT AS AMOUNT"
										  +"                 ,CURRENT_AMT"
										  +"                 ,A.GIFT_NO"
										  +"                 ,EXTEND_NO"
										  +"                 ,CASE WHEN APLONLINEID IN ('balancegift''balancetran')"
										  +"                       THEN 'MS'"
										  +"                       ELSE PAY_KIND"
										  +"                   END AS PAY_KIND"
										  +"            FROM   KPC_APPROVAL.RC_APPROVAL A"
										  +"                  ,KPC_APPROVAL.VW_SUBMERCHANT_SERVICE F"
										  +"                  ,(SELECT  S.CSEQNO AS ORDER_NO"
										  +"                           ,AUTHNO"
										  +"                           ,PAYMEMO"
										  +"                           ,S.PAYKIND"
										  +"                    FROM   KPC_APPROVAL.HM_SALE S"
										  +"                          ,KPC_APPROVAL.HM_PAY P"
										  +"                    WHERE  S.CSEQNO = P.CSEQNO"
										  +"                      AND  SITE = 'mobilepop'"
										  +"                      AND  P.STATUS = 'S'"
										  +"                   ) P"
										  +"                  ,KPC_APPROVAL.GIFTEXTEND GE"
										  +"            WHERE  A.APLONLINEID = F.SVC_CONN_ID"
										  +"              AND  F.DEL_FLAG = 'N'"
										  +"              AND  A.APLORDERNO = P.ORDER_NO(+)"
										  +"              AND  A.GIFT_NO = GE.GIFT_NO"
										  +"              AND  APLDATE BETWEEN #{searchDate} AND TO_DATE( #{searchDate} ||'235959', 'YYYYMMDDHH24MISS')"
										  +"        UNION ALL"
										  +" SELECT 'payment' AS KIND,"
										  +"        APLDATE,"
										  +"        APLTIME,"
										  +"        INSERTDATE AS INSERT_DT,"
										  +"        A.MERCHANTID,"
										  +"        DECODE(A.MERCHANTID, 'gspopcardp', 'GS25 / ', 'gssmpopp', 'GS수퍼 / ')|| F.NAME AS APLONLINEID,"
										  +"        RESERVED01,"
										  +"        REQORDERNO,"
										  +"        APLNO,"
										  +"        RESULTCODE,"
										  +"        ORDERAMT,"
										  +"        CURRENT_AMT,"
										  +"        GIFT_NO,"
										  +"        EXTEND_NO,"
										  +"        CASE"
										  +"            WHEN A.MERCHANTID IN ('toppingpop','hotdealpop')"
										  +"            THEN 'OP'"
										  +"            ELSE GIFTNAME"
										  +"         END GIFTNAME"
										  +"  FROM KPC_APPROVAL.ORDERLIST_POS A,"
										  +"       KPC_APPROVAL.VW_SUBMERCHANT_SERVICE F,"
										  +"       KPC_APPROVAL.MTRANS C,"
										  +"       KPC_APPROVAL.ORDERDETAIL O,"
										  +"       KPC_APPROVAL.GIFTEXTEND G"
										  +" WHERE A.MERCHANTID = F.SVC_CONN_ID"
										  +"   AND F.DEL_FLAG = 'N'"
										  +"   AND A.TRANSID = C.TRANSID(+)"
										  +"   AND A.TRANSID = O.TRANSID"
										  +"   AND O.C_SERIAL = G.GIFT_SEQ"
										  +"   AND (GIFTNAME IN ('CP','BP','OP') OR     RESULTCODE = 'R1')"
										  +"   AND    APLDATE = TO_CHAR(TO_DATE(#{searchDate}) -1, 'YYYYMMDD')"
										  +"UNION ALL"
										  +" SELECT 'happycash' AS KIND,"
										  +"        TO_CHAR(CHARGE_DT, 'YYYYMMDD') AS APLDATE,"
										  +"        TO_CHAR(CHARGE_DT, 'HH24MISS') AS APLTIME,"
										  +"        CHARGE_DT AS INSERT_DT,"
										  +"        'happymoney' AS APLONLINEID,"
										  +"        '해피캐시' AS APLONLINE_NM,"
										  +"        NULL AS BARCODE_NO,"
										  +"        HCASH_ID AS APLORDERNO,"
										  +"        NULL AS APLNO,"
										  +"        DECODE(STATUS_CD, '01', 'O1', '02', 'D1', '99', 'O1') AS STATUS,"
										  +"        CASE"
										  +"            WHEN CHARGE_AMT = 0 AND    STATUS_CD= '99'"
										  +"            THEN (SELECT CHARGE_AMT"
										  +"                    FROM KPC_APPROVAL.HCASH_HISTORY"
										  +"                   WHERE HCASH_ID = A.HCASH_ID"
										  +"                     AND CHARGE_AMT > 0)"
										  +"            ELSE CHARGE_AMT"
										  +"         END AS AMOUNT,"
										  +"        NULL AS CURRENT_AMT,"
										  +"        A.GIFT_NO,"
										  +"        EXTEND_NO,"
										  +"        'OP' AS PAY_KIND"
										  +"  FROM KPC_APPROVAL.HCASH_HISTORY a,"
										  +"       KPC_APPROVAL.GIFTEXTEND B"
										  +" WHERE CHARGE_METHOD = 'GS'"
										  +"   AND A.GIFT_NO = B.GIFT_NO"
										  +"   AND CHARGE_DT BETWEEN TO_CHAR(TO_DATE(#{searchDate}) -1, 'YYYYMMDD') AND TO_DATE( TO_CHAR(TO_DATE(#{searchDate}) -1, 'YYYYMMDD') ||'235959', 'YYYYMMDDHH24MISS')"
										  +"UNION ALL"
										  +" SELECT 'refund' AS KIND,"
										  +"        TO_CHAR(COMPLETE_DATETIME, 'YYYYMMDD') AS APLDATE,"
										  +"        TO_CHAR(COMPLETE_DATETIME, 'hh24miss') AS APLTIME,"
										  +"        COMPLETE_DATETIME AS INSERT_DT,"
										  +"        'happymoney' AS APLONLINEID,"
										  +"        '환불폐기' AS APLONLINE_NM,"
										  +"        NULL AS BARCODE_NO,"
										  +"        SEQ AS APLORDERNO,"
										  +"        NULL AS APLNO,"
										  +"        DECODE(STATUS, '2', 'O1') AS STATUS,"
										  +"        REFUND_POS_AMT,"
										  +"        0 AS CURRENT_AMT,"
										  +"        A.GIFT_NO,"
										  +"        EXTEND_NO,"
										  +"        'CC' AS PAY_KIND"
										  +"  FROM KPC_APPROVAL.HM_REFUND A,"
										  +"       KPC_APPROVAL.GIFTEXTEND B"
										  +" WHERE A.GIFT_NO = B.GIFT_NO"
										  +"   AND A.GIFT_NO IS NOT NULL"
										  +"   AND EXISTS (SELECT 1"
										  +"                 FROM (SELECT GIFT_NO,"
										  +"                              GIFT_CD"
										  +"                         FROM KPC_APPROVAL.GIFTCREATE"
										  +"                        UNION ALL"
										  +"                       SELECT GIFT_NO,"
										  +"                              GIFT_CD"
										  +"                         FROM KPC_APPROVAL.GIFTDELETE)"
										  +"                        WHERE GIFT_NO = A.GIFT_NO"
										  +"                          AND GIFT_CD = 'SCARD')"
										  +"   AND    STATUS = '2'"
										  +"   AND    COMPLETE_DATETIME BETWEEN TO_CHAR(TO_DATE(#{searchDate}) -1, 'YYYYMMDD') AND TO_DATE( TO_CHAR(TO_DATE(#{searchDate}) -1, 'YYYYMMDD') ||'235959', 'YYYYMMDDHH24MISS')"
										  +" ) A";
	
	@Resource(name="approvalDataSource")
	@Insert(INSERT_SQL)
	public int insert(@Param("popCardSettlementList") List<PopCardDealsSettlement> popCardSettlementList);
	
	@Resource(name="approvalDataSource")
	@Delete(DELETE_SQL)
	public int delete(String workDt);

	@Resource(name="approvalDataSource")
	@Select(SELECT_SQL)
	public List<PopCardDealsSettlement> select(String searchDate);	
	
}
