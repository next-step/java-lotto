package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000, (countOfMatch, hitBonusBall) -> countOfMatch == 5 && hitBonusBall),
    THIRD(5, 1500000, (countOfMatch, hitBonusBall) -> countOfMatch == 5 && !hitBonusBall),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0, (countOfMatch, hitBonusBall) -> countOfMatch >= 0 && countOfMatch < 3);

    private static final String INVALID_COUNT_VALUE_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 값입니다. countOfMatch: %s, hitBonusBall: %s";

    private final int countOfMatchForWinning;
    private final Money winningMoney;
    private final BiPredicate<Integer, Boolean> winningCondition;

    Rank(int countOfMatchForWinning, long winningAmount, BiPredicate<Integer, Boolean> winningCondition) {
        this.countOfMatchForWinning = countOfMatchForWinning;
        this.winningMoney = Money.of(winningAmount);
        this.winningCondition = winningCondition;
    }

    Rank(int countOfMatchForWinning, long winningMoneyAmount) {
        this(countOfMatchForWinning, winningMoneyAmount, (countOfMatch, hitBonusBall) -> countOfMatchForWinning == countOfMatch);
    }

    public static List<Rank> winningValues() {
        return Arrays.stream(values())
                .filter(rank -> !MISS.equals(rank))
                .collect(Collectors.toList());
    }

    public static Rank valueOf(int countOfMatch, boolean hitBonusBall) {
        return Arrays.stream(values())
                .filter(rank -> rank.win(countOfMatch, hitBonusBall))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(INVALID_COUNT_VALUE_EXCEPTION_MESSAGE_FORMAT, countOfMatch, hitBonusBall)));
    }

    private boolean win(int countOfMatch, boolean hitBonusBall) {
        return winningCondition.test(countOfMatch, hitBonusBall);
    }

    public int getCountOfMatchForWinning() {
        return countOfMatchForWinning;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public Money calculateTotalWinningAmount(int count) {
        return winningMoney.multiply(count);
    }
}
