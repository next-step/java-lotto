package lotto.domain;

public class WinLottoNumber {

    private static boolean[] duplicationLottoNumberArr = new boolean[46];
    private LottoNumber winLottoNumber;


    public WinLottoNumber(LottoNumber winLottoNumber) {
        this.winLottoNumber = winLottoNumber;
        checkWinLotto();
    }

    private void checkWinLotto() {
        for (Number number : winLottoNumber.numbers()) {
            duplicationLottoNumberArr[number.number()] = true;
        }
    }

    public int checkDuplicationLotto(LottoNumber lottoNumber) {
        int duplicationCount = 0;

        for (Number number : lottoNumber.numbers()) {
            if (duplicationLottoNumberArr[number.number()]) {
                duplicationCount++;
            }
        }
        return duplicationCount;
    }


}
