package kr.co.kpcard.backoffice.repository.approval.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * KPC_ADMIN 데이터베이스
 * KPC_APPROVAL 테이블 목록 조회용 모델
 * Created by @author : MinWook on 2018. 6. 12.
 *
 */
@Getter
@Setter
public class ApprovalForList {
	
	/**
	 * 요청 번호(PK)
	 */
	private Long seq;
	
	/**
	 * 요청 정보 번호
	 */
	private Long contentSeq;
	
	/**
	 * 업무 유형
	 */
	private String workType;
	private String workTypeName;
	
	/**
	 * 처리 구분
	 */
	private String reqType;
	private String reqTypeName;
	
	/**
	 * 진행 상태
	 */
	private String status;
	private String statusName;
	
	/**
	 * 참조 대상 ID
	 */
	private String refId;
	
	/**
	 * 참조 대상 제목
	 */
	private String refTitle;
	
	/**
	 * 요청 정보 설명
	 */
	private String description;
	
	/**
	 * 검색 키워드
	 */
	private String keyword;
	
	/**
	 * 신청자 사번
	 */
	private String reqEmpId;
	
	/**
	 * 신청자 이름
	 */
	private String reqEmpName;
	
	/**
	 * 신청일
	 */
	private Date reqDate;
	
	/**
	 * 승인 요청 사유
	 */
	private String reqMemo;
	
	/**
	 * 승인자 사번
	 */
	private String apprEmpId;
	
	/**
	 * 승인자 이름
	 */
	private String apprEmpName;
	
	/**
	 * 승인일
	 */
	private Date apprDate;
	
	/**
	 * 요청 처리 사유
	 */
	private String apprMemo;
	
	/**
	 * 생성일자
	 */
	private Date createDate;
	
	/**
	 * 수정일자
	 */
	private Date updateDate;
}