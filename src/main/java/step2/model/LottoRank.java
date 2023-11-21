package step2.model;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    NO_PRIZE(0, 0, ""),
    FIFTH_PRIZE(3, 5_000, "3개 일치 (5000원)- %s개\n"),
    FOURTH_PRIZE(4, 50_000, "4개 일치 (50000원)- %s개\n"),
    THIRD_PRIZE(5, 1_500_000, "5개 일치 (1500000원)- %s개\n"),
    SECOND_PRIZE(5,3_000_000, "5개 일치, 보너스 볼 일치(30000000원) - %s개\n"),
    FIRST_PRIZE(6, 2_000_000_000, "6개 일치 (2000000000)- %s개\n");

    private static final int MAX_NO_PRIZE_NUMBER = 2;
    private static final int MATCH_COUNT_SECOND_OR_THIRD = 5;
    private static final Map<Integer, LottoRank> lottoRankMapping =
            Stream.of(values())
                    .collect(Collectors.toMap(
                            lottoRank -> lottoRank.matchCount,
                            lottoRank -> lottoRank,
                            (existing, replacement) -> existing // 중복된 키가 있을 때 기존 값을 유지하도록 함
                    ));

    private final int matchCount;
    private final long prizeMoney;
    private final String printMessage;

    LottoRank(int matchCount, long prizeMoney, String printMessage) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.printMessage = printMessage;
    }

    public static LottoRank findLottoRankByMatchCountAndMatchBonus(int matchCount, boolean matchBonus) {
        if (matchCount <= MAX_NO_PRIZE_NUMBER) {
            return NO_PRIZE;
        }
        if (isSecondPrize(matchCount, matchBonus)) {
            return SECOND_PRIZE;
        }
        if (isThirdPrize(matchCount, matchBonus)) {
            return THIRD_PRIZE;
        }
        return lottoRankMapping.get(matchCount);
    }

    private static boolean isSecondPrize(int matchCount, boolean matchBonus) {
        return matchCount == MATCH_COUNT_SECOND_OR_THIRD && matchBonus;
    }

    private static boolean isThirdPrize(int matchCount, boolean matchBonus) {
        return matchCount == MATCH_COUNT_SECOND_OR_THIRD && !matchBonus;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrintMessage() {
        return printMessage;
    }
}
