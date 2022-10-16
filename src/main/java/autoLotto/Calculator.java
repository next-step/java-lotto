package autoLotto;

import static autoLotto.Match.*;

public class Calculator {
    public double matchNumber(Lottos lottos, Numbers numbers, int amount) {
        System.out.println("amout :: " + amount);
        Long totalAmount = 0L;
        for (int i = 0 ; i < lottos.getLottosSize() ; i++) {
            int matchNumQuantity = lottos.getLotto(i).getMatchQuantity(numbers.getNumbers());

            getTotalCount(matchNumQuantity);
            totalAmount = getTotalAmount();
        }
        return Math.floor(((double)totalAmount / amount) * 100) / 100.0;
    }

    private Long getTotalAmount() {
        Long result = 0L;

        result += THREE.getCountOfMatch() * THREE.getWinningAmount();
        result += FOUR.getCountOfMatch() * FOUR.getWinningAmount();
        result += FIVE.getCountOfMatch() * FIVE.getWinningAmount();
        result += SIX.getCountOfMatch() * SIX.getWinningAmount();

        return result;
    }

    private void getTotalCount(int matchNumQuantity) {
        if (matchNumQuantity == THREE.getMatchNum()) {
            THREE.countOfMatch();
        }

        if (matchNumQuantity == FOUR.getMatchNum()) {
            FOUR.countOfMatch();
        }

        if (matchNumQuantity == FIVE.getMatchNum()) {
            FIVE.countOfMatch();
        }

        if (matchNumQuantity == SIX.getMatchNum()) {
            SIX.countOfMatch();
        }
    }
}
