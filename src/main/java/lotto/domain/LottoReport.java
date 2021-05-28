package lotto.domain;

import lotto.EarningResultMessage;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoMachine.*;

public class LottoReport {

	private static final int SCALE = 2;

	private final Map<LottoRank, Integer> lottoRankMap = new EnumMap<>(LottoRank.class);
	private final List<LottoRank> lottoRankList;
	private final BigDecimal earnings;

	public LottoReport(List<LottoRank> lottoRankList) {
		this.lottoRankList = lottoRankList;
		earnings = sumEarnings(lottoRankList);

		countPerRank(lottoRankList);
	}

	private BigDecimal sumEarnings(List<LottoRank> lottoRankList) {
		BigDecimal decimal = new BigDecimal(0);

		for (LottoRank lottoRank : lottoRankList) {
			decimal = decimal.add(BigDecimal.valueOf(lottoRank.money()));
		}

		return decimal;
	}

	private void countPerRank(List<LottoRank> lottoRankList) {
		for (LottoRank lottoRank : lottoRankList) {
			lottoRankMap.put(lottoRank, lottoRankMap.getOrDefault(lottoRank, 0) + 1);
		}
	}

	public BigDecimal earningRatio() {
		return earnings.divide(new BigDecimal(spentMoney()), SCALE, BigDecimal.ROUND_DOWN);
	}

	public String earningResultMessage() {
		BigDecimal earningRatio = earnings.divide(new BigDecimal(spentMoney()), SCALE, BigDecimal.ROUND_DOWN);

		return EarningResultMessage.get(earningRatio.compareTo(BigDecimal.ONE));
	}

	private int spentMoney() {
		return lottoRankList.size() * PRICE;
	}

	public Map<LottoRank, Integer> lottoRankMap() {
		return Collections.unmodifiableMap(new EnumMap<>(lottoRankMap));
	}
}
