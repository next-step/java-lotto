package lotto.domain;

import static lotto.domain.LottoRank.*;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoReport {

	public static final String LINE_SEPARATOR = "\r\n";
	public static final int SCALE = 2;
	public static final String LOSS = "손해";
	public static final String GOOD = "이득";
	public static final String NOTHING = "본전";

	private static final String MESSAGE_FORMAT = "%d개 일치 (%s원)- %d개";
	private static final String SECOND_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원)- %d개";
	private static final Map<Integer, String> EARNING_RESULT_MAP = new HashMap<>();

	static {
		EARNING_RESULT_MAP.put(-1, LOSS);
		EARNING_RESULT_MAP.put(1, GOOD);
		EARNING_RESULT_MAP.put(0, NOTHING);
	}

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

	public String lottoRankMessage() {
		return buildLottoRankMessage();
	}

	private String buildLottoRankMessage() {
		return formatMessage(FIFTH) + LINE_SEPARATOR
			+ formatMessage(FOURTH) + LINE_SEPARATOR
			+ formatMessage(THIRD) + LINE_SEPARATOR
			+ formatMessage(SECOND) + LINE_SEPARATOR
			+ formatMessage(FIRST) + LINE_SEPARATOR;
	}

	private String formatMessage(LottoRank lottoRank) {
		if (lottoRank.equals(SECOND)) {
			return String.format(SECOND_MESSAGE_FORMAT, lottoRank.matchCount(), lottoRank.money(),
				lottoRankMap.getOrDefault(lottoRank, 0));
		}

		return String.format(MESSAGE_FORMAT, lottoRank.matchCount(), lottoRank.money(),
			lottoRankMap.getOrDefault(lottoRank, 0));
	}

	public BigDecimal earningRatio() {
		return earnings.divide(new BigDecimal(spentMoney()), SCALE, BigDecimal.ROUND_DOWN);
	}

	public String earningResultMessage() {
		BigDecimal earningRatio = earnings.divide(new BigDecimal(spentMoney()), SCALE, BigDecimal.ROUND_DOWN);

		return EARNING_RESULT_MAP.get(earningRatio.compareTo(BigDecimal.ONE));
	}

	private int spentMoney() {
		return lottoTicketCount * LottoStore.PRICE;
	}

}
