package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRankEnum {

    FIRST(new BigDecimal(2000000000), 6, "6개 일치 (2000000000원)- "),
    SECOND(new BigDecimal(30000000), 5, "5개 일치 , 보너스 볼 일치(30000000원)- "),
    THIRD(new BigDecimal(15000000), 5, "5개 일치 (15000000원)- "),
    FOURTH(new BigDecimal(50000), 4, "4개 일치 (50000원)- "),
    FIVE(new BigDecimal(5000), 3, "3개 일치 (5000)- "),
    LOSING_LOT(BigDecimal.ZERO, 2, "");


    private BigDecimal winningAmount;
    private int matchCnt;
    private String description;

    private LottoRankEnum(BigDecimal winningAmount, int matchCnt, String description) {
        this.winningAmount = winningAmount;
        this.matchCnt = matchCnt;
        this.description = description;
    }

    public static LottoRankEnum getRank(int matchCnt, boolean isBonusMatch) {
        if (matchCnt != SECOND.getMatchCnt()) {
            return Arrays.stream(values()).filter(rank -> rank.matchCnt == matchCnt).findFirst().orElse(LOSING_LOT);
        }
        if (isBonusMatch) {
            return SECOND;
        }
        return THIRD;
    }

    public static List<LottoRankEnum> valuesWithoutMiss() {
        return Arrays.stream(values()).filter(rank -> !rank.equals(LOSING_LOT)).collect(Collectors.toList());
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public BigDecimal getWinningAmount() {
        return winningAmount;
    }

    public String getDescription() {
        return description;
    }
}
