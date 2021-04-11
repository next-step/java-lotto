package lotto.domain;

public class WinLottoNumber {

    private static boolean[] duplicationLottoNumberArr = new boolean[46];
    private LottoNumber winLottoNumber;
    private LottoNumber bonusNumber;
    private int duplicationCount = 0;

    public WinLottoNumber(LottoNumber winLottoNumber) {
        this.winLottoNumber = winLottoNumber;
        checkWinLotto();
    }


    public int duplicationLotto(LottoNumber lottoNumber) {

        for (Number number : lottoNumber.numbers()) {
            increaseCount(number);
        }
        return duplicationCount;
    }

    private void checkWinLotto() {
        for (Number number : winLottoNumber.numbers()) {
            duplicationLottoNumberArr[number.number()] = true;
        }
    }

    private void increaseCount(Number number) {
        if (duplicationLottoNumberArr[number.number()]) {
            duplicationCount++;
        }
    }

    private boolean bonusNumber(Number number){
        return false;
    }


}
