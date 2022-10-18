package autoLotto;

public class Calculator {
    private static final int INIT_NUM = 0;

    public double calculate(Lottos lottos, WinningNumbers winningNumbers, int amount) {
        long totalAmount = INIT_NUM;
        for (int i = 0 ; i < lottos.getLottosSize() ; i++) {
            Lotto lotto = lottos.getLotto(i);
            getTotalCount(lotto.getMatchQuantity(winningNumbers.getWinningNumbers()));
            totalAmount = getTotalAmount();
        }
        return Math.floor(((double)totalAmount / amount) * 100) / 100.0;
    }

    private long getTotalAmount() {
        long result = INIT_NUM;

        for (Match match : Match.values()) {
            result += match.getTotalAmount();
        }

        return result;
    }

    private void getTotalCount(int matchNumQuantity) {

        if (matchNumQuantity >= 3) {
            Match match = Matcher.get(matchNumQuantity);
            match.countOfMatch();
        }
    }
}
