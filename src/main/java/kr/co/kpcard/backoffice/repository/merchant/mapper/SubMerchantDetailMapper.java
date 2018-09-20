package kr.co.kpcard.backoffice.repository.merchant.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.kpcard.backoffice.repository.merchant.model.SubMerchantDetail;
/**
 * SUBMERCHANT_DETAIL 테이블을 조회하는 맵퍼
 * Created by @author : MinWook on 2018. 7. 2.
 *
 */
@Mapper
public interface SubMerchantDetailMapper {

	public static final String CREATE_SUB_MERCHANT_DETAIL = "INSERT INTO KPC_ADMIN.SUBMERCHANT_DETAIL "
            + "        ( "
            + "           submerchant_id "
            + "          ,biz_kind "
            + "          ,biz_cond "
            + "          ,corp_reg_no "
            + "          ,biz_reg_no "
            + "          ,ceo_nm "
            + "          ,type "
            + "          ,open_dt "
            + "          ,bank_nm "
            + "          ,bank_acc_no "
            + "          ,bank_holder " 
            + "          ,zipcode "
            + "          ,address "
            + "          ,address_dtl "
            + "          ,tel "
            + "          ,fax "
            + "          ,tax_cust_nm "
            + "          ,tax_email "
            + "          ,tax_tel "
            + "          ,tax_phone "
            + "          ,tax_fax "
            + "          ,sales_nm "
            + "          ,sales_tel "
            + "          ,billing_nm "
            + "          ,billing_tel "
            + "          ,kpc_sales_nm "
            + "          ,kpc_sales_tel "
            + "          ,kpc_billing_nm "
            + "          ,kpc_billing_tel "
            + "          ,url_home "
            + "        ) "
            + " VALUES ( "
            + "           #{subMerchantDetail.subMerchantId} "
            + "          ,#{subMerchantDetail.bizKind} "
            + "          ,#{subMerchantDetail.bizCond} "
            + "          ,#{subMerchantDetail.corpRegNo} "
            + "          ,#{subMerchantDetail.bizRegNo} "
            + "          ,#{subMerchantDetail.ceoName} "
            + "          ,#{subMerchantDetail.type} "
            + "          ,#{subMerchantDetail.openDate} "
            + "          ,#{subMerchantDetail.bankName} "
            + "          ,#{subMerchantDetail.bankAccountNo} "
            + "          ,#{subMerchantDetail.bankHolder} "
            + "          ,#{subMerchantDetail.zipCode} "
            + "          ,#{subMerchantDetail.address} "
            + "          ,#{subMerchantDetail.addressDetail} "
            + "          ,#{subMerchantDetail.tel} "
            + "          ,#{subMerchantDetail.fax} "
            + "          ,#{subMerchantDetail.taxCustName} "
            + "          ,#{subMerchantDetail.taxEmail} "
            + "          ,#{subMerchantDetail.taxTel} "
            + "          ,#{subMerchantDetail.taxPhone} "
            + "          ,#{subMerchantDetail.taxFax} "
            + "          ,#{subMerchantDetail.salesName} "
            + "          ,#{subMerchantDetail.salesTel} "
            + "          ,#{subMerchantDetail.billingName} "
            + "          ,#{subMerchantDetail.billingTel} "
            + "          ,#{subMerchantDetail.kpcSalesName} "
            + "          ,#{subMerchantDetail.kpcSalesTel} "
            + "          ,#{subMerchantDetail.kpcBillingName} "
            + "          ,#{subMerchantDetail.kpcBillingTel} "
            + "          ,#{subMerchantDetail.urlHome} "
            + "        ) ";
	@Insert(CREATE_SUB_MERCHANT_DETAIL)
	public int createSubMerchantDetail(@Param(value="subMerchantDetail")SubMerchantDetail subMerchantDetail);
		
	public static final String READ_SUBMERCHANT_DETAIL = "select"
			+ 	"	 submerchant_id subMerchantId "
			+ 	"	,biz_kind bizKind "
			+ 	"	,biz_cond bizCond "
			+ 	"	,corp_reg_no corpRegNo "
			+ 	"	,biz_reg_no bizRegNo "
			+ 	"	,cust_nm custName "
			+ 	"	,cust_tel custTel "
			+ 	"	,ceo_nm ceoName "
			+ 	"	,type "
			+ 	"	,open_dt openDate "
			+ 	"	,bank_nm bankName "
			+ 	"	,bank_acc_no bankAccountNo "
			+ 	"	,bank_holder bankHolder "
			+ 	"	,zipcode zipCode "
			+ 	"	,address as address "
			+ 	"	,address_dtl as addressDetail "
			+ 	"	,tel "
			+ 	"	,fax "
			+ 	"	,tax_cust_nm taxCustName "
			+ 	"	,tax_email taxEmail "
			+ 	"	,tax_tel taxTel "
			+ 	"	,tax_phone taxPhone "
			+ 	"	,tax_fax taxFax "
			+ 	"	,sales_nm salesName "
			+ 	"	,sales_tel salesTel "
			+ 	"	,billing_nm billingName "
			+ 	"	,billing_tel billingTel "
			+ 	"	,kpc_sales_nm kpcSalesName "
			+ 	"	,kpc_sales_tel kpcSalesTel "
			+ 	"	,kpc_billing_nm kpcBillingName "
			+ 	"	,kpc_billing_tel kpcBillingTel "
			+ 	"	,url01 "
			+ 	"	,url02 "
			+ 	"	,url_home urlHome "
			+ 	"from submerchant_detail "
			+   "where submerchant_id = #{subMerchantId} ";
	@Select(READ_SUBMERCHANT_DETAIL)
	public SubMerchantDetail readSubMerchantDetail(@Param(value="subMerchantId")String subMerchantId);
	
	public static final String  UPDATE_SUB_MERCHANT_DETAIL = "update submerchant_detail set "
			+ "  biz_kind = #{subMerchantDetail.bizKind, jdbcType=VARCHAR} "
			+ " ,biz_cond = #{subMerchantDetail.bizCond, jdbcType=VARCHAR} "
			+ " ,corp_reg_no = #{subMerchantDetail.corpRegNo, jdbcType=VARCHAR} "
			+ " ,biz_reg_no = #{subMerchantDetail.bizRegNo, jdbcType=VARCHAR} "
			+ " ,cust_nm = #{subMerchantDetail.custName, jdbcType=VARCHAR} "
			+ " ,cust_tel = #{subMerchantDetail.custTel, jdbcType=VARCHAR} "
			+ " ,ceo_nm = #{subMerchantDetail.ceoName, jdbcType=VARCHAR} "
			+ " ,type = #{subMerchantDetail.type, jdbcType=VARCHAR} "
			+ " ,open_dt = #{subMerchantDetail.openDate, jdbcType=VARCHAR} "
			+ " ,bank_nm = #{subMerchantDetail.bankName, jdbcType=VARCHAR} "
			+ " ,bank_acc_no = #{subMerchantDetail.bankAccountNo, jdbcType=VARCHAR} "
			+ " ,bank_holder = #{subMerchantDetail.bankHolder, jdbcType=VARCHAR} "
			+ " ,zipcode = #{subMerchantDetail.zipCode, jdbcType=VARCHAR} "
			+ " ,address = #{subMerchantDetail.address, jdbcType=VARCHAR} "
			+ " ,address_dtl = #{subMerchantDetail.addressDetail, jdbcType=VARCHAR} "
			+ " ,tel = #{subMerchantDetail.tel, jdbcType=VARCHAR} "
			+ " ,fax = #{subMerchantDetail.fax, jdbcType=VARCHAR} "
			+ " ,tax_cust_nm = #{subMerchantDetail.taxCustName, jdbcType=VARCHAR} "
			+ " ,tax_email = #{subMerchantDetail.taxEmail, jdbcType=VARCHAR} "
			+ " ,tax_tel = #{subMerchantDetail.taxTel, jdbcType=VARCHAR} "
			+ " ,tax_phone = #{subMerchantDetail.taxPhone, jdbcType=VARCHAR} "
			+ " ,tax_fax = #{subMerchantDetail.taxFax, jdbcType=VARCHAR} "
			+ " ,sales_nm = #{subMerchantDetail.salesName, jdbcType=VARCHAR} "
			+ " ,sales_tel = #{subMerchantDetail.salesTel, jdbcType=VARCHAR} "
			+ " ,billing_nm = #{subMerchantDetail.billingName, jdbcType=VARCHAR} "
			+ " ,billing_tel = #{subMerchantDetail.billingTel, jdbcType=VARCHAR} "
			+ " ,kpc_sales_nm = #{subMerchantDetail.kpcSalesName, jdbcType=VARCHAR} "
			+ " ,kpc_sales_tel = #{subMerchantDetail.kpcSalesTel, jdbcType=VARCHAR} "
			+ " ,kpc_billing_nm = #{subMerchantDetail.kpcBillingName, jdbcType=VARCHAR} "
			+ " ,kpc_billing_tel = #{subMerchantDetail.kpcBillingTel, jdbcType=VARCHAR} "
			+ " ,url01 = #{subMerchantDetail.url01, jdbcType=VARCHAR} "
			+ " ,url02 = #{subMerchantDetail.url02, jdbcType=VARCHAR} "
			+ " ,url_home = #{subMerchantDetail.urlHome, jdbcType=VARCHAR} "
			+ "	WHERE SUBMERCHANT_ID = #{subMerchantDetail.subMerchantId} ";
	@Update(UPDATE_SUB_MERCHANT_DETAIL)
	public void updateSubMerchantDetail(@Param(value="subMerchantDetail")SubMerchantDetail subMerchantDetail);
}
