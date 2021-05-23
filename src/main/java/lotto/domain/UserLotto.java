package lotto.domain;

import java.util.List;

class UserLotto {

	private static final String INVALID_LOTTO_TICKET_LIST_MESSAGE = "로또 티켓이 유효하지 않습니다.";
	private static final String LINE_SEPARATOR = "\r\n";

	private final List<LottoTicket> lottoTicketList;

	UserLotto(List<LottoTicket> lottoTicketList) {
		validate(lottoTicketList);

		this.lottoTicketList = lottoTicketList;
	}

	private void validate(List<LottoTicket> lottoTicketList) {
		if (lottoTicketList == null || lottoTicketList.size() == 0) {
			throw new IllegalArgumentException(INVALID_LOTTO_TICKET_LIST_MESSAGE);
		}
	}

	int count() {
		return lottoTicketList.size();
	}

	String lottoNumbers() {
		return buildLottoNumberMessage();
	}

	private String buildLottoNumberMessage() {
		StringBuilder build = new StringBuilder();

		for (LottoTicket lottoTicket : lottoTicketList) {
			build.append(lottoTicket.toString())
				.append(LINE_SEPARATOR);
		}

		return build.toString();
	}

}
