package kr.co.kpcard.protocol.settlement.smartro;

import kr.co.kpcard.common.utils.StringUtil;

public class DealStartRecord implements RecordInterface{


	protected final static int LEN_SIZE = 200;
	protected final static int LEN_DIVIDER = 1;
	protected final static int LEN_SERVICE_DIVIDER = 3;
	protected final static int LEN_CREATE_DATE = 6;
	protected final static int LEN_MERCHANT_CORP_NO = 10;
	protected final static int LEN_VAN_CORP_NO = 10;
	protected final static int LEN_CREATOR = 3;
	protected final static int LEN_FILLER = 167;
	
	private String divider; // 레코더 구분 : 1 ("S") 
	private String serviceDivider; // 서비스 구분 : 3 ("TLF") 
	private String createDate; // 파일 작성일 : 6 
	private String merchantCorpNo; // 가맹점 사업자 등록 번호 : 10 
	private String vanCorpNo; // VAN 사업자 등록번호 : 10
	private String creator; // 생성 주체 : 3 ("S":스마트로 , "M":가맹점 생성 ) 
	private String filler; // filler : 167 
	
	
	public DealStartRecord(){}
	
	public DealStartRecord(byte[] record)
	{
		this.pasre(record);
	}
	
	@Override
	public boolean pasre(byte[] record) 
	{
		// TODO Auto-generated method stub
		boolean result = false; 
		
		try 
		{
			this.divider = StringUtil.copyToString(record
					, 0
					, LEN_DIVIDER);
			
			this.serviceDivider = StringUtil.copyToString(record
					, LEN_DIVIDER 
					, LEN_SERVICE_DIVIDER);
			
			this.createDate = StringUtil.copyToString(record
					, LEN_DIVIDER + LEN_SERVICE_DIVIDER
					, LEN_CREATE_DATE);
			
			this.merchantCorpNo = StringUtil.copyToString(record
					, LEN_DIVIDER + LEN_SERVICE_DIVIDER
					+ LEN_CREATE_DATE
					, LEN_MERCHANT_CORP_NO);
			
			this.vanCorpNo = StringUtil.copyToString(record
					, LEN_DIVIDER + LEN_SERVICE_DIVIDER
					+ LEN_CREATE_DATE + LEN_MERCHANT_CORP_NO
					, LEN_VAN_CORP_NO);
			
			this.creator = StringUtil.copyToString(record
					, LEN_DIVIDER + LEN_SERVICE_DIVIDER
					+ LEN_CREATE_DATE + LEN_MERCHANT_CORP_NO
					+ LEN_VAN_CORP_NO
					, LEN_CREATOR);
			
			this.filler = StringUtil.copyToString(record
					, LEN_DIVIDER + LEN_SERVICE_DIVIDER
					+ LEN_CREATE_DATE + LEN_MERCHANT_CORP_NO
					+ LEN_VAN_CORP_NO + LEN_CREATOR
					, LEN_FILLER);
				
			result = true;
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		
			return false; 
		}
		
		return result;
	}

	@Override
	public int validate()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public String getDivider() {
		return divider;
	}

	public String getServiceDivider() {
		return serviceDivider;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getMerchantCorpNo() {
		return merchantCorpNo;
	}

	public String getVanCorpNo() {
		return vanCorpNo;
	}

	public String getCreator() {
		return creator;
	}

	public String getFiller() {
		return filler;
	}

	@Override
	public String toString() 
	{
		return String.format(
				"DealStartRecord [divider=%s, serviceDivider=%s, createDate=%s"
				+ ", merchantCorpNo=%s, vanCorpNo=%s, creator=%s"
				+ ", filler=%s]",
				divider, serviceDivider, createDate
				, merchantCorpNo, vanCorpNo, creator
				, filler);
	}

	
	
}
