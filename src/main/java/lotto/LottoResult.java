package lotto;

public class LottoResult {
    private int countFristLotto = 0;
    private int countSecondLotto = 0;
    private int countThirdLotto = 0;
    private int countFourthLotto = 0;

    public boolean isFirst(int expectedCount) {
        return this.countFristLotto == expectedCount;
    }
    public boolean isSecond(int expectedCount) {
        return this.countSecondLotto == expectedCount;
    }
    public boolean isThird(int expectedCount) {
        return this.countThirdLotto == expectedCount;
    }

    public boolean isFourth(int expectedCount) {
        return this.countFourthLotto == expectedCount;
    }

    public void checkRank(int compareWinLottoNumber) {
        if (compareWinLottoNumber == 3) {
            countFourthLotto++;
            return;
        }
        if (compareWinLottoNumber == 4) {
            countThirdLotto++;
            return;
        }
        if (compareWinLottoNumber == 5) {
            countSecondLotto++;
            return;
        }
    }

    public void winLotto() {
        countFristLotto++;
    }
}
