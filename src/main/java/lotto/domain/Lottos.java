package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lottos {

	private List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public HashMap<LottoRank, Integer> getWinningStatistics(List<Integer> winningNumber) {
		HashMap<LottoRank, Integer> result = new HashMap<>();

		for (Lotto lotto : this.lottos) {
			int count = lotto.getLottoNumber().getCountOfMatchLottoNumber(winningNumber);
			result.merge(LottoRank.findLottoRankByLottoCount(count), 1, Integer::sum);
		}

		return result;
	}

}
