package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
	private static final int INCREMENT_VALUE = 1;

	private List<LottoNumbers> lottos;

	public Lottos(List<LottoNumbers> lottos) {
		this.lottos = lottos;
	}

	public HashMap<LottoRank, Integer> getWinningStatistics(WinningLottoNumber winningLottoNumber) {
		return (HashMap<LottoRank, Integer>) lottos.stream()
				.map(lotto -> LottoRank.findLottoRankByLottoCount(lotto.getCountOfMatchLottoNumber(winningLottoNumber.getWinningLottoNumbers()),
						lotto.containsLottoNumber(winningLottoNumber.getBonusNumber())))
				.filter(rank -> rank != null)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> INCREMENT_VALUE)));
	}

	public List<LottoNumbers> getLottos() {
		return lottos;
	}

}
