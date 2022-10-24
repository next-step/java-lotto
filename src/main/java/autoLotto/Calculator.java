package autoLotto;

public class Calculator {
    private static final int INIT_NUM = 0;

    public static double calculate(Lottos lottos, WinningNumbers winningNumbers) {
        long totalAmount = getTotalAmount(lottos, winningNumbers);
        return Math.floor(((double)totalAmount / lottos.getAmount()) * 100) / 100.0;
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
