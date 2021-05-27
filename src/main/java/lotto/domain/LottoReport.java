package lotto.domain;

import lotto.EarningResultMessage;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoReport {

	public static final int SCALE = 2;

	private final Map<LottoRank, Integer> lottoRankMap;
	private final int lottoTicketCount;

	private BigDecimal earnings = new BigDecimal(0);

	public LottoReport(List<LottoRank> lottoRankList) {
		lottoTicketCount = lottoRankList.size();
		lottoRankMap = new EnumMap<>(LottoRank.class);

		for (LottoRank lottoRank : lottoRankList) {
			lottoRankMap.put(lottoRank, lottoRankMap.getOrDefault(lottoRank, 0) + 1);
			earnings = earnings.add(BigDecimal.valueOf(lottoRank.money()));
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
		return lottoTicketCount * LottoStore.PRICE;
	}

	public Map<LottoRank, Integer> lottoRankMap() {
		return Collections.unmodifiableMap(new EnumMap<>(lottoRankMap));
	}
}
