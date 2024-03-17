package lotto.domain;

import static lotto.LottoConstants.*;

public class LottoResult {
    private int countOfThreeCorrectLotto = 0;
    private int countOfFourCorrectLotto = 0;
    private int countOfFiveCorrectLotto = 0;
    private int countOfSixCorrectLotto = 0;

    public long winnings() {
        return (countOfThreeCorrectLotto * THREE_NUMBER_CORRECT_WINNINGS)
                + (countOfFourCorrectLotto * FOUR_NUMBER_CORRECT_WINNINGS)
                + (countOfFiveCorrectLotto * FIVE_NUMBER_CORRECT_WINNINGS)
                + (countOfSixCorrectLotto * SIX_NUMBER_CORRECT_WINNINGS);
    }

    public void addCorrectLottoCount(int count) {
        if (count == 3) {
            countOfThreeCorrectLotto++;
        }
        if (count == 4) {
            countOfFourCorrectLotto++;
        }
        if (count == 5) {
            countOfFiveCorrectLotto++;
        }
        if (count == 6) {
            countOfSixCorrectLotto++;
        }
    }

    public double rateOfReturn(int lottoCount) {
        double rateOfReturn = (double) winnings() / (lottoCount * LOTTO_PRICE);
        return Math.floor(rateOfReturn * 100) / 100.0;
    }
}
