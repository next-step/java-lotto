package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoRank {

    NOT_MATCHED("", false, 0, new LottoPrize(BigDecimal.ZERO, Currency.KRW)),
    FIFTH("3개 일치", false, 3, new LottoPrize(BigDecimal.valueOf(5000), Currency.KRW)),
    FOURTH("4개 일치", false, 4, new LottoPrize(BigDecimal.valueOf(50000), Currency.KRW)),
    THIRD("5개 일치", false, 5, new LottoPrize(BigDecimal.valueOf(1500000), Currency.KRW)),
    SECOND("5개 일치, 보너스 볼 일치", true, 5, new LottoPrize(BigDecimal.valueOf(30000000), Currency.KRW)),
    FIRST("6개 일치", false, 6, new LottoPrize(BigDecimal.valueOf(2000000000), Currency.KRW));

    private final String description;
    private final boolean hasBonus;
    private final int matchedCount;
    private final LottoPrize prize;

    LottoRank(String description,
              boolean hasBonus,
              int matchedCount,
              LottoPrize prize) {
        this.description = description;
        this.hasBonus = hasBonus;
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public String description() {
        return this.description;
    }

    public static LottoRank searchBy(int matchedCount,
                                     boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> isMatchedCount(matchedCount, lottoRank) && hasBonus(hasBonus, lottoRank))
                .findFirst()
                .orElse(LottoRank.NOT_MATCHED);
    }

    private static boolean hasBonus(boolean hasBonus,
                                    LottoRank lottoRank) {
        return lottoRank.hasBonus == hasBonus;
    }

    private static boolean isMatchedCount(int matchedCount,
                                          LottoRank lottoRank) {
        return lottoRank.matchedCount == matchedCount;
    }

    public long calculatePrize(long value) {
        return prize.calculateAmount(value);
    }

    public boolean isWin() {
        return this != LottoRank.NOT_MATCHED;
    }

    public String prizeToString() {
        return this.prize.toString();
    }
}
