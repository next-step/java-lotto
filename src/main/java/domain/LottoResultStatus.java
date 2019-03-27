package domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum LottoResultStatus {
    NONE(Arrays.asList(0,1,2), false, 0L, ""),
    WINNING_NUM_3(Arrays.asList(3), false, 5_000L, "3개 일치"),
    WINNING_NUM_4(Arrays.asList(4), false, 50_000L, "4개 일치"),
    WINNING_NUM_5(Arrays.asList(5), false, 1_500_000L, "5개 일치"),
    WINNING_NUM_5_BONUS(Arrays.asList(5), true, 1_500_000L, "5개 일치, 보너스 볼 일치"),
    WINNING_NUM_6(Arrays.asList(6), false, 2_000_000_000L, "6개 일치");


    private List<Integer> matchCounts;
    private boolean bonusMatchYn;
    private Long winnersPrice;
    private String description;

    LottoResultStatus(List<Integer> matchCount, boolean bonusMatchYn, Long winnersPrice, String description) {
        this.matchCounts = matchCount;
        this.bonusMatchYn = bonusMatchYn;
        this.winnersPrice = winnersPrice;
        this.description = description;
    }

    public static LottoResultStatus findByMatchCount(int matchCount, boolean bonusYn) {
        return Arrays.stream(LottoResultStatus.values())
                .filter(matchCountGroup -> matchCountGroup.hasMatchCount(matchCount, bonusYn))
                .findAny()
                .orElse(NONE);
    }

    public boolean hasMatchCount(Integer matchCount, boolean bonusYn) {
        return this.matchCounts.contains(matchCount) && this.bonusMatchYn == bonusYn;
    }

    public static BigDecimal getWinnersPriceByStatus(int lottoCount, LottoResultStatus status) {
        return BigDecimal.valueOf(lottoCount * status.winnersPrice);
    }
}
