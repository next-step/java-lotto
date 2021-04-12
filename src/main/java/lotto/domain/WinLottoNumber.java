package lotto.domain;

import lotto.enums.Rank;

public class WinLottoNumber {

    private static boolean[] duplicationLottoNumberArr = new boolean[46];
    private LottoNumber winLottoNumber;
    private Number bonusNumber;
    private int duplicationCount = 0;

    public WinLottoNumber(LottoNumber winLottoNumber,Number bonusNumber){
        this(winLottoNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinLottoNumber(LottoNumber winLottoNumber) {
        this.winLottoNumber = winLottoNumber;
        checkWinLotto();
    }


//    public int duplicationLotto(LottoNumber lottoNumber) {
//
//        for (Number number : lottoNumber.numbers()) {
//            increaseCount(number);
//        }
//        return duplicationCount;
//    }

    public Rank duplicationLotto(LottoNumber lottoNumber) {

        for (Number number : lottoNumber.numbers()) {
            increaseCount(number);
        }
        return checkedWinLotto(duplicationCount);
    }

    private Rank checkedWinLotto(int duplicationCount) {
        return Rank.valueOf(duplicationCount,false);
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

    private Number bonusNumber(Number number) {
        return this.bonusNumber;
    }


}
