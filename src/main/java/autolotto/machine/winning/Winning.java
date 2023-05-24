package autolotto.machine.winning;

import autolotto.machine.lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public enum Winning {
    ZERO(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private static final Map<Integer, Winning> winningsMap = new HashMap<>();

    static {
        for (Winning winning : values()) {
            winningsMap.put(winning.matchNumber, winning);
        }
        winningsMap.remove(Winning.ZERO.matchNumber);
    }

    private final int matchNumber;
    private final int winningMoney;

    Winning(int matchNumber, int winningMoney) {
        this.matchNumber = matchNumber;
        this.winningMoney = winningMoney;
    }

    public static Winning winningOf(int matchCount, boolean isBonusBallMatched) {
        if (isSecondPrize(matchCount, isBonusBallMatched)) {
            return FIVE_BONUS;
        }

        return Optional.ofNullable(winningsMap.get(matchCount))
                .orElse(Winning.ZERO);
    }

    public static Winning winningOf(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = lotto.matchCount(winningNumbers);
        boolean isBonusBallMatched = lotto.contains(winningNumbers.bonusNumber().value());

        return winningOf(matchCount, isBonusBallMatched);
    }

    public static int totalAmountOf(List<Lotto> lotteries, WinningNumbers winningNumbers) {
        return lotteries.stream()
                .mapToInt(lotto -> Winning.winningOf(lotto, winningNumbers).winningMoney())
                .sum();
    }
    private static boolean isSecondPrize(int matchCount, boolean isBonusBallMatched) {
        return matchCount == FIVE.matchNumber && isBonusBallMatched;
    }

    public static int minWinningMatchCount() {
        return Winning.THREE.matchNumber;
    }

    public int winningMoney() {
        return this.winningMoney;
    }

    public int matchNumber() {
        return this.matchNumber;
    }
}
