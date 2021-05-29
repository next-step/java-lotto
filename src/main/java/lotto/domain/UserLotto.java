package lotto.domain;

import static lotto.OutputView.*;
import static lotto.util.CollectionUtils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserLotto {

	private static final String NO_LOTTO_TICKET_LIST_MESSAGE = "구매한 로또 티켓이 없습니다.";

	private final List<LottoTicket> lottoTickets;

	UserLotto(List<LottoTicket> lottoTicketList) {
		lottoTickets = Optional.ofNullable(lottoTicketList)
			.filter(lottoTicket -> lottoTicket.size() > 0)
			.orElseThrow(() -> new IllegalArgumentException(NO_LOTTO_TICKET_LIST_MESSAGE));
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

	@Override
	public String toString() {
		return lottoTickets.stream()
			.map(LottoTicket::toString)
			.collect(Collectors.joining(LINE_SEPARATOR));
	}
}
