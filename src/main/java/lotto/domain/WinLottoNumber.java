package lotto.domain;

import lotto.enums.Rank;

public class WinLottoNumber {

    private static boolean[] duplicationLottoNumberArr = new boolean[46];
    private LottoNumber winLottoNumber;
    private Number bonusNumber;
    private boolean matchedBonusNumber = false;
    private int duplicationCount = 0;

    public WinLottoNumber(LottoNumber winLottoNumber, Number bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.winLottoNumber = winLottoNumber;
        checkWinLotto();
    }

    public Rank duplicationLottoRank(LottoNumber lottoNumber) {
        for (Number number : lottoNumber.numbers()) {
            increaseCountAndCheckBonusNumber(number);
        }
        return checkedWinLotto(duplicationCount);
    }

    private Rank checkedWinLotto(int duplicationCount) {
        return Rank.valueOf(duplicationCount, matchedBonusNumber);
    }

    private void checkWinLotto() {
        for (Number number : winLottoNumber.numbers()) {
            duplicationLottoNumberArr[number.number()] = true;
        }
    }

    private void increaseCountAndCheckBonusNumber(Number number) {
        if (duplicationLottoNumberArr[number.number()]) {
            duplicationCount++;
        }

        if (number.number() == bonusNumber.number()) {
            matchedBonusNumber = true;
        }
    }

}
