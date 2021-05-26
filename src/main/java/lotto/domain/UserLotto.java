package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserLotto {

	private static final String INVALID_LOTTO_TICKET_LIST_MESSAGE = "로또 티켓이 유효하지 않습니다.";
	private static final String LINE_SEPARATOR = "\r\n";

	private final List<LottoTicket> lottoTicketList;

	UserLotto(List<LottoTicket> lottoTicketList) {
		validate(lottoTicketList);

		this.lottoTicketList = Collections.unmodifiableList(lottoTicketList);
	}

	private void validate(List<LottoTicket> lottoTicketList) {
		if (lottoTicketList == null || lottoTicketList.size() == 0) {
			throw new IllegalArgumentException(INVALID_LOTTO_TICKET_LIST_MESSAGE);
		}
	}

	public int count() {
		return lottoTicketList.size();
	}

	public String lottoNumberMessage() {
		return buildLottoNumberMessage();
	}

	private String buildLottoNumberMessage() {
		return lottoTicketList.stream()
				.map(LottoTicket::toString)
				.collect(Collectors.joining(LINE_SEPARATOR));
	}

	public List<LottoTicket> lottoTickets() {
		return lottoTicketList;
	}

}
