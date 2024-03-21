package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class Lottos {
	private static final int MIN_WINNING_NUMBER = 3;
	private static final int INCREMENT_VALUE = 1;

	private List<LottoNumbers> lottos;

	public Lottos(List<LottoNumbers> lottos) {
		this.lottos = lottos;
	}

	public HashMap<LottoRank, Integer> getWinningStatistics(WinningLottoNumbers winningLottoNumbers) {
		HashMap<LottoRank, Integer> result = new HashMap<>();

		for (LottoNumbers lotto : lottos) {
			int count = lotto.getCountOfMatchLottoNumber(winningLottoNumbers);
			if (count >= MIN_WINNING_NUMBER)
				result.merge(LottoRank.findLottoRankByLottoCount(count), INCREMENT_VALUE, Integer::sum);
		}

		return result;
	}

	public List<LottoNumbers> getLottos() {
		return lottos;
	}

}
