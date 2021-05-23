package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoVendor {

	private final LottoTicket winningLottoTicket;

	public LottoVendor(String winningLottoNumbers) {
		this.winningLottoTicket = new LottoTicket(winningLottoNumbers);
	}

	public LottoReport report(List<LottoTicket> lottoTickets) {
		List<LottoRank> lottoRankList = new ArrayList<>();
		addLottoRanks(lottoTickets, lottoRankList);

		return new LottoReport(lottoRankList);
	}

	private void addLottoRanks(List<LottoTicket> lottoTickets, List<LottoRank> lottoRankList) {
		for (LottoTicket lottoTicket : lottoTickets) {
			lottoRankList.add(lottoRank(lottoTicket));
		}
	}

	private LottoRank lottoRank(LottoTicket lottoTicket) {
		return LottoRank.rank(matchCount(lottoTicket));
	}

	private int matchCount(LottoTicket lottoTicket) {
		return LottoTicket.compare(lottoTicket, winningLottoTicket);
	}

}
