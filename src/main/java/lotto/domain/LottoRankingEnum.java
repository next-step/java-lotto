package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoRankingEnum {

    FOURTH_PRIZE(new BigDecimal(5000), 3),
    THIRD_PRIZE(new BigDecimal(50000), 4),
    SECOND_PRIZE(new BigDecimal(1500000), 5),
    FIRST_PRIZE(new BigDecimal(2000000000), 6),
    LOSING_LOT(BigDecimal.ZERO, -1);


    private BigDecimal winningAmount ;
    private int matchCnt;

    LottoRankingEnum(BigDecimal winningAmount, int matchCnt) {
        this.winningAmount = winningAmount;
        this.matchCnt = matchCnt;
    }

    public BigDecimal getWinningAmount() {
        return winningAmount;
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public static LottoRankingEnum getEnumByMatchCount(int matchCnt) {
        return Arrays.stream(values()).filter(e -> e.getMatchCnt() == matchCnt).findFirst().orElse(LOSING_LOT);
    }
}
