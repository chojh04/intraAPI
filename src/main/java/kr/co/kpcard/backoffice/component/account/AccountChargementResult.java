package kr.co.kpcard.backoffice.component.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountChargementResult {
	private String seq;
	private String summSeq;
	private String submerchantId;
	private String submerchantNm;
	private String serviceId;
	private String serviceNm;
	private String serviceType;
	private String serviceCategory;
	private String svcConnId;
	private String dealDivider;
	private String dealDt;
	private String approvalDt;
	private String approvalStatusNm;
	private String approvalStatus;
	private String approvalNo;
	private String orderNo;
	private String saleDivider;
	private String saleDividerName;
	private String cardCdName;
	private String cardCd;
	private String cardNm;
	private String cardNo;
	private String cardEncNo;
	private String cardMngNo;
	private String amount;
	private String balance;
	private String chargeType;
	private String chargeTypeName;
	private String chargeMethod;
	private String chargeMethodName;
	private String chargeStatusName;
	private String storeCd;
	private String storeNm;
	private String posNo;
	private String cpId;
	private String cpUserId;
	private String cpUserIp;
	private String agentId;
	private String commision;
	private String merchantCommtype;
	private String merchantCommision;
	private String merchantTaxType;
	private String merchantTax;
	private String kpcCommType;
	private String kpcCommision;
	private String kpcTaxType;
	private String kpcTax;
	private String addCommType01;
	private String addCommision01;
	private String addTaxType01;
	private String addTax01;
	private String addCommType02;
	private String addCommision02;
	private String addTaxType02;
	private String addTax02;
	private String billingSum;
	private String desc01;
	private String desc02;
	private String linkUrl;
	public void setValues(String seq, String summSeq,
			String submerchantId, String submerchantNm, String serviceId,
			String serviceNm, String serviceType, String serviceCategory,
			String svcConnId, String dealDivider, String dealDt,
			String approvalDt, String approvalStatusNm, String approvalStatus,
			String approvalNo, String orderNo, String saleDivider,
			String saleDividerName, String cardCdName, String cardCd,
			String cardNm, String cardNo, String cardEncNo, String cardMngNo,
			String amount, String balance, String chargeType,
			String chargeTypeName, String chargeMethod,
			String chargeMethodName, String chargeStatusName, String storeCd,
			String storeNm, String posNo, String cpId, String cpUserId,
			String cpUserIp, String agentId, String commision,
			String merchantCommtype, String merchantCommision,
			String merchantTaxType, String merchantTax, String kpcCommType,
			String kpcCommision, String kpcTaxType, String kpcTax,
			String addCommType01, String addCommision01, String addTaxType01,
			String addTax01, String addCommType02, String addCommision02,
			String addTaxType02, String addTax02, String billingSum,
			String desc01, String desc02, String linkUrl) {
		this.seq = seq;
		this.summSeq = summSeq;
		this.submerchantId = submerchantId;
		this.submerchantNm = submerchantNm;
		this.serviceId = serviceId;
		this.serviceNm = serviceNm;
		this.serviceType = serviceType;
		this.serviceCategory = serviceCategory;
		this.svcConnId = svcConnId;
		this.dealDivider = dealDivider;
		this.dealDt = dealDt;
		this.approvalDt = approvalDt;
		this.approvalStatusNm = approvalStatusNm;
		this.approvalStatus = approvalStatus;
		this.approvalNo = approvalNo;
		this.orderNo = orderNo;
		this.saleDivider = saleDivider;
		this.saleDividerName = saleDividerName;
		this.cardCdName = cardCdName;
		this.cardCd = cardCd;
		this.cardNm = cardNm;
		this.cardNo = cardNo;
		this.cardEncNo = cardEncNo;
		this.cardMngNo = cardMngNo;
		this.amount = amount;
		this.balance = balance;
		this.chargeType = chargeType;
		this.chargeTypeName = chargeTypeName;
		this.chargeMethod = chargeMethod;
		this.chargeMethodName = chargeMethodName;
		this.chargeStatusName = chargeStatusName;
		this.storeCd = storeCd;
		this.storeNm = storeNm;
		this.posNo = posNo;
		this.cpId = cpId;
		this.cpUserId = cpUserId;
		this.cpUserIp = cpUserIp;
		this.agentId = agentId;
		this.commision = commision;
		this.merchantCommtype = merchantCommtype;
		this.merchantCommision = merchantCommision;
		this.merchantTaxType = merchantTaxType;
		this.merchantTax = merchantTax;
		this.kpcCommType = kpcCommType;
		this.kpcCommision = kpcCommision;
		this.kpcTaxType = kpcTaxType;
		this.kpcTax = kpcTax;
		this.addCommType01 = addCommType01;
		this.addCommision01 = addCommision01;
		this.addTaxType01 = addTaxType01;
		this.addTax01 = addTax01;
		this.addCommType02 = addCommType02;
		this.addCommision02 = addCommision02;
		this.addTaxType02 = addTaxType02;
		this.addTax02 = addTax02;
		this.billingSum = billingSum;
		this.desc01 = desc01;
		this.desc02 = desc02;
		this.linkUrl = linkUrl;
	}
	
}
