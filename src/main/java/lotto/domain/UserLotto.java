package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static lotto.util.CollectionUtils.*;

public class UserLotto {

	private static final String INVALID_LOTTO_TICKET_LIST_MESSAGE = "로또 티켓이 유효하지 않습니다.";

	private final List<LottoTicket> lottoTickets;

	UserLotto(List<LottoTicket> lottoTicketList) {
		lottoTickets = Optional.ofNullable(lottoTicketList)
				.filter(lottoTicket -> lottoTicket.size() > 0)
				.orElseThrow(() -> new IllegalArgumentException(INVALID_LOTTO_TICKET_LIST_MESSAGE));
	}

	public int count() {
		return lottoTickets.size();
	}

	public List<LottoTicket> lottoTickets() {
		return Collections.unmodifiableList(lottoTickets);
	}

	public LottoReport report(WinningLotto winningLotto) {
		return new LottoReport(Collections.unmodifiableList(
				transform(lottoTickets, new ArrayList<>(), winningLotto::rank)));
	}

}
