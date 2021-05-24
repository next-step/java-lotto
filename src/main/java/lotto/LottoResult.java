package lotto;

public class LottoResult {
    private int countFourthLotto = 0;

    public boolean isFourth(int expectedCount) {
        return this.countFourthLotto == expectedCount;
    }

    public void checkWin(int compareWinLottoNumber) {
        if (compareWinLottoNumber == 3) {
            countFourthLotto++;
        }
    }
}
