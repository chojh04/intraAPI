package kr.co.kpcard.backoffice.repository.merchant.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantMerchant {
	private String submerchant_id;
	private String erp_code;
	private String depth;
	private String parent_id;
	private String parentName;
	private String child_id;
	private String name;
	private String name_eng;
	private String alias;
	private String alias_eng;
	private String use_flag;
	private String useFlagName;
	private String reuse_flag;
	private String del_flag;
	private String pg_id;
	private String pg_pw;
	private String agent_id;
	private String agent_pw;
	private String biz_kind;
	private String biz_cond;
	private String corp_reg_no;
	private String biz_reg_no;
	private String cust_nm;
	private String cust_tel;
	private String ceo_nm;
	private String type;
	private String biz_grp;
	private String bankCd;
	private String bankNm;
	private String bank_acc_no;
	private String bank_holder;
	private String zipcode;
	private String address;
	private String address_dtl;
	private String tel;
	private String fax;
	private String tax_cust_nm;
	private String tax_email;
	private String tax_tel;
	private String tax_phone;
	private String tax_fax;
	private String sales_nm;
	private String sales_tel;
	private String billing_nm;
	private String billing_tel;
	private String kpc_sales_nm;
	private String kpc_sales_tel;
	private String kpc_billing_nm;
	private String kpc_billing_tel;
	private String url01;
	private String url02;
	private String url_home;
	private String openDt;
	private String path;
}