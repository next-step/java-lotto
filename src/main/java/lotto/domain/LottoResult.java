package lotto.domain;

public class LottoResult {
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

    public void addResultCount(int count) {
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
}
