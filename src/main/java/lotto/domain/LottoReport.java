package lotto.domain;

import static lotto.domain.LottoRank.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoReport {

	public static final String LINE_SEPARATOR = "\r\n";
	public static final int SCALE = 2;

	private static final String MESSAGE_FORMAT = "%d개 일치 (%s원)- %d개";

	private final Map<LottoRank, Integer> lottoRankMap;
	private final int lottoTicketCount;

	private BigDecimal earnings = new BigDecimal(0);

	public LottoReport(List<LottoRank> lottoRankList) {
		lottoTicketCount = lottoRankList.size();
		lottoRankMap = new HashMap<>(lottoRankList.size());

		for (LottoRank lottoRank : lottoRankList) {
			lottoRankMap.put(lottoRank, lottoRankMap.getOrDefault(lottoRank, 0) + 1);
			earnings = earnings.add(BigDecimal.valueOf(lottoRank.money()));
		}
	}

	public String lottoRankMessage() {
		return buildLottoRankMessage();
	}

	private String buildLottoRankMessage() {
		return formatMessage(FOURTH) + LINE_SEPARATOR
			+ formatMessage(THIRD) + LINE_SEPARATOR
			+ formatMessage(SECOND) + LINE_SEPARATOR
			+ formatMessage(FIRST) + LINE_SEPARATOR;
	}

	private String formatMessage(LottoRank fourth) {
		return String.format(MESSAGE_FORMAT, fourth.matchCount(), fourth.money(), lottoRankMap.getOrDefault(fourth, 0));
	}

	public BigDecimal earningRatio() {
		return earnings.divide(new BigDecimal(lottoTicketCount * LottoStore.PRICE), SCALE, BigDecimal.ROUND_DOWN);
	}
}
