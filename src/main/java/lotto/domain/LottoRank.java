package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum LottoRank {

    NOT_MATCHED("", new LottoPrize(BigDecimal.ZERO, Currency.KRW), (count, hasBonus) -> count >= 0 && count < 3),
    FIFTH("3개 일치", new LottoPrize(BigDecimal.valueOf(5000), Currency.KRW), (count, hasBonus) -> count == 3),
    FOURTH("4개 일치", new LottoPrize(BigDecimal.valueOf(50000), Currency.KRW), (count, hasBonus) -> count == 4),
    THIRD("5개 일치", new LottoPrize(BigDecimal.valueOf(1500000), Currency.KRW), (count, hasBonus) -> count == 5 && !hasBonus),
    SECOND("5개 일치, 보너스 볼 일치", new LottoPrize(BigDecimal.valueOf(30000000), Currency.KRW), (count, hasBonus) -> count == 5 && hasBonus),
    FIRST("6개 일치", new LottoPrize(BigDecimal.valueOf(2000000000), Currency.KRW), (count, hasBonus) -> count == 6);

    private final String description;
    private final LottoPrize prize;
    private final BiFunction<Integer, Boolean, Boolean> isMatched;

    LottoRank(String description,
              LottoPrize prize,
              BiFunction<Integer, Boolean, Boolean> isMatched) {
        this.description = description;
        this.prize = prize;
        this.isMatched = isMatched;
    }

    public String description() {
        return this.description;
    }

    public static LottoRank searchBy(int matchedCount,
                                     boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.isMatched(matchedCount, hasBonus))
                .findFirst()
                .orElse(LottoRank.NOT_MATCHED);
    }

    private boolean isMatched(int matchedCount,
                              boolean hasBonus) {
        return isMatched.apply(matchedCount, hasBonus);
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
