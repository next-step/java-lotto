package step2.domain.type;

import step2.domain.Lotto;
import step2.domain.PrizeLotto;
import step2.exception.NotFoundPrizeException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum Prize {

    SEVENTH(0, Bonus.NOT_USE, BigDecimal.ZERO),
    SIXTH(1, Bonus.NOT_USE, BigDecimal.ZERO),
    FIFTH(2, Bonus.NOT_USE, BigDecimal.ZERO),
    FOURTH(3, Bonus.NOT_USE, BigDecimal.valueOf(5000)),
    THIRD(4, Bonus.NOT_USE, BigDecimal.valueOf(50000)),
    SECOND(5, Bonus.USE_AND_NOT_MATCHED, BigDecimal.valueOf(1500000)),
    SECOND_WITH_BONUS(5, Bonus.USE_AND_MATCHED, BigDecimal.valueOf(30000000)),
    FIRST(6, Bonus.NOT_USE, BigDecimal.valueOf(2000000000));

    private static final List<Prize> WINNING = Arrays.asList(FIRST, SECOND_WITH_BONUS, SECOND, THIRD, FOURTH);

    private int matchCount;
    private Bonus bonus;
    private BigDecimal prizeMoney;

    Prize(int matchCount, Bonus bonus, BigDecimal prizeMoney) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize of(Lotto lotto, PrizeLotto prizeLotto) {
        int countOfWinningNumber = lotto.countOfWinningNumber(prizeLotto);
        boolean isBonusMatched = lotto.isBonusMatched(prizeLotto);

        return Arrays.stream(Prize.values())
            .filter(prize -> prize.equal(countOfWinningNumber, isBonusMatched))
            .findFirst()
            .orElseThrow(() -> new NotFoundPrizeException());
    }

    private boolean equal(int matchCount, boolean isBonusMatched) {
        return equalMatchCount(matchCount) && equalBonus(isBonusMatched);
    }

    private boolean equalMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean equalBonus(boolean isBonusMatched) {
        return this.bonus.equalBonus(isBonusMatched);
    }

    public static boolean isWinningPrize(Prize prize) {
        return WINNING.contains(prize);
    }

    public int matchCount() {
        return this.matchCount;
    }

    public boolean useBonusAndMatched() {
        return this.bonus.useBonusAndMatched();
    }

    public BigDecimal prizeMoney() {
        return this.prizeMoney;
    }

}
