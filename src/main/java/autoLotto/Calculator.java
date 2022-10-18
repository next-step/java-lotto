package autoLotto;

public class Calculator {

    public double calculate(Lottos lottos, WinningNumbers winningNumbers, int amount) {
        Long totalAmount = 0L;
        for (int i = 0 ; i < lottos.getLottosSize() ; i++) {
            getTotalCount(lottos.getLotto(i).getMatchQuantity(winningNumbers.getWinningNumbers()));
            totalAmount = getTotalAmount();
        }
        return Math.floor(((double)totalAmount / amount) * 100) / 100.0;
    }

    private Long getTotalAmount() {
        Long result = 0L;

        for ( Match match : Match.values()) {
            result += match.getTotalAmount();
        }

        return result;
    }

    private void getTotalCount(int matchNumQuantity) {
        Match match = Matcher.get(matchNumQuantity);
        match.countOfMatch();
    }
}
