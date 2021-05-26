package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {

	private static final String INVALID_LOTTO_TICKET_LIST_MESSAGE = "로또 티켓이 유효하지 않습니다.";

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

	public List<LottoTicket> lottoTickets() {
		return lottoTicketList;
	}

	public LottoReport report(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
		List<LottoRank> lottoRankList = new ArrayList<>();

		for (LottoTicket lottoTicket : lottoTicketList) {
			lottoRankList.add(
				LottoRank.rank(countCommonNumber(winningLottoTicket, lottoTicket), isBonus(bonusNumber, lottoTicket)));
		}

		return new LottoReport(lottoRankList);
	}

	private int countCommonNumber(LottoTicket winningLottoTicket, LottoTicket lottoTicket) {
		return LottoTicket.countCommonNumber(lottoTicket, winningLottoTicket);
	}

	private boolean isBonus(LottoNumber bonusNumber, LottoTicket lottoTicket) {
		return lottoTicket.matchNumber(bonusNumber);
	}
}
