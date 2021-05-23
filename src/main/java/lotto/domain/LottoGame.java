package lotto.domain;

import java.util.List;

class LottoGame {

	private static final String INVALID_LOTTO_TICKET_LIST_MESSAGE = "로또 티켓이 유효하지 않습니다.";

	private final List<LottoTicket> lottoTicketList;

	LottoGame(List<LottoTicket> lottoTicketList) {
		validate(lottoTicketList);

		this.lottoTicketList = lottoTicketList;
	}

	private void validate(List<LottoTicket> lottoTicketList) {
		if (lottoTicketList == null || lottoTicketList.size() == 0) {
			throw new IllegalArgumentException(INVALID_LOTTO_TICKET_LIST_MESSAGE);
		}
	}

}
