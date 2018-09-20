package kr.co.kpcard.backoffice.service.card;

import java.util.List;

import kr.co.kpcard.backoffice.component.ListSummary;
import kr.co.kpcard.backoffice.repository.card.mapper.BalanceRefund;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResGetApproveCardRefund {
	private ListSummary summary;
	private BalanceRefund result;
}
