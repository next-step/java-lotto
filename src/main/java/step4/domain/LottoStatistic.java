package step4.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

public class LottoStatistic {
	private static final String INIT_SUM = "0";
	private static final int SCALE = 2;
	private static final int LOTTO_PRICE = 1000;

	private final Map<Rank, Integer> lottoResultMap;

	public LottoStatistic() {
		lottoResultMap = new EnumMap<>(Rank.class);
	}

	public Map<Rank, Integer> calculateLottoResult(Lottos issueLottos, WinningLotto winningLotto) {
		lottoResultMap.putAll(issueLottos.getLottosMap(winningLotto));
		return lottoResultMap;
	}

	public BigDecimal calculateYield(int size) {
		BigDecimal yield = new BigDecimal(INIT_SUM);
		for (Rank winning : lottoResultMap.keySet()) {
			yield = yield.add(BigDecimal.valueOf(lottoResultMap.get(winning) * winning.getReward()));
		}
		return yield.divide(BigDecimal.valueOf(size*LOTTO_PRICE), SCALE, RoundingMode.HALF_EVEN);
	}
}
