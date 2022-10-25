package autoLotto;

public class Calculator {
    private static final int INIT_NUM = 0;

    public static void calculate(Lottos lottos, WinningNumbers winningNumbers, GameResult result) {
        result.makeWinningStatistics(getTotalAmount(lottos, winningNumbers), lottos.getAmount());
    }

    private static long getTotalAmount(Lottos lottos, WinningNumbers winningNumbers) {
        long totalAmount = INIT_NUM;
        for (Lotto lotto : lottos.getLottos()) {
            int count = lotto.countOfMatch(winningNumbers.getWinningNumbers());
            boolean bonus = lotto.matchBonus(winningNumbers.getBonusNumber());

            totalAmount += Rank.valueOf(count, bonus);
        }
        return totalAmount;
    }
}
