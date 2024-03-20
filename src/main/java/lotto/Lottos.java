package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lottos {

	private List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<LottoRank> getWinningStatistics(List<Integer> winningNumber) {
		List<LottoRank> result = new ArrayList<>();
		for (Lotto lotto : this.lottos) {
			int count = lotto.getLottoNumber().getCountOfMatchLottoNumber(winningNumber);
			result.add(LottoRank.findLottoRankByLottoCount(count));
		}
		return result;
	}

}
