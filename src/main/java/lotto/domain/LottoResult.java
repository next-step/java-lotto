package lotto.domain;

import static lotto.constants.LottoConstants.*;

public class LottoResult {
    private int lottoCount = 0;
    private int countOfThreeCorrectLotto = 0;
    private int countOfFourCorrectLotto = 0;
    private int countOfFiveCorrectLotto = 0;
    private int countOfSixCorrectLotto = 0;

    public int getCountOfThreeCorrectLotto() {
        return countOfThreeCorrectLotto;
    }

    public int getCountOfFourCorrectLotto() {
        return countOfFourCorrectLotto;
    }

    public int getCountOfFiveCorrectLotto() {
        return countOfFiveCorrectLotto;
    }

    public int getCountOfSixCorrectLotto() {
        return countOfSixCorrectLotto;
    }

    private long winnings() {
        return (countOfThreeCorrectLotto * THREE_NUMBER_CORRECT_WINNINGS)
                + (countOfFourCorrectLotto * FOUR_NUMBER_CORRECT_WINNINGS)
                + (countOfFiveCorrectLotto * FIVE_NUMBER_CORRECT_WINNINGS)
                + (countOfSixCorrectLotto * SIX_NUMBER_CORRECT_WINNINGS);
    }

    public void addCorrectLottoCount(int count) {
        lottoCount++;
        if (count == 3) {
            countOfThreeCorrectLotto++;
            return;
        }
        if (count == 4) {
            countOfFourCorrectLotto++;
            return;
        }
        if (count == 5) {
            countOfFiveCorrectLotto++;
            return;
        }
        if (count == 6) {
            countOfSixCorrectLotto++;
        }
    }

    public double rateOfReturn() {
        double rateOfReturn = (double) winnings() / (lottoCount * LOTTO_PRICE);
        return Math.floor(rateOfReturn * 100) / 100.0;
    }
}
