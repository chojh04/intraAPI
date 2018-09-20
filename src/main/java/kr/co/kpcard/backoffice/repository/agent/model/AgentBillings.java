package kr.co.kpcard.backoffice.repository.agent.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentBillings {
	private String service_billing_id;
	private String service_id;
	private String name;
	private String code;
	private String codeName;
	private String divider;
	private String dividerName;
	private String bankCd;
	private String bankNm;
	private String bank_acc_no;
	private String vr_bank_nm;
	private String vr_bank_acc_no;
	private String bank_holder;
	private String billing_dt;
	private String billing_duration;
	private String billingDurationName;
	private String merchant_comm_type;
	private String merchantCommTypeName;
	private String merchant_commision;
	private String merchant_tax_type;
	private String merchantTaxTypeName;
	private String merchant_tax;
	private String mng_nm;
	private String mng_tel;
	private String mng_email;
	private String kpc_mng_nm;
	private String kpc_mng_tel;
	private String kpc_mng_email;
	private String create_dt;
	private String apl_end_dt;
	private String expectedMerchantCommision;
	
	public String getBilling_dt_name() {
		return "D+ " + this.billing_dt + " 일";
	}
	
	public String getBillingDurationName() {
		return this.billingDurationName + " 일";
	}
	
	public String getMerchant_commisionName() {
		return this.merchant_commision +"%";
	}
	
}
