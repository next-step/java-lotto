package domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum LottoResultStatus {
    NONE(Arrays.asList(0,1,2), 0L),
    WINNING_NUM_3(Arrays.asList(3), 5_000L),
    WINNING_NUM_4(Arrays.asList(4), 50_000L),
    WINNING_NUM_5(Arrays.asList(5), 150_000L),
    WINNING_NUM_6(Arrays.asList(6), 2_000_000_000L);


    private List<Integer> matchCounts;
    private Long winnersPrice;

    LottoResultStatus(List<Integer> matchCount, Long winnersPrice) {
        this.matchCounts = matchCount;
        this.winnersPrice = winnersPrice;
    }

    public static LottoResultStatus findByMatchCount(int matchCount) {
        return Arrays.stream(LottoResultStatus.values())
                .filter(matchCountGroup -> matchCountGroup.hasMatchCount(matchCount))
                .findAny()
                .orElse(NONE);
    }

    public boolean hasMatchCount(Integer integer) {
        return matchCounts.contains(integer);
    }

    public static BigDecimal getWinnersPriceByStatus(int matchCount, LottoResultStatus status) {
        return BigDecimal.valueOf(matchCount * status.winnersPrice);
    }

}
