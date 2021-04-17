package lotto.domain;

import lotto.enums.Rank;

public class WinLottoNumber {

    private static boolean[] duplicationLottoNumberArr = new boolean[46];
    private LottoNumber winLottoNumber;
    private Number bonusNumber;
    private boolean matchedBonusNumber = false;
    private int duplicationCount = 0;

    public WinLottoNumber(LottoNumber winLottoNumber, Number bonusNumber) {
        inspectDuplicationNumber(winLottoNumber, bonusNumber);
        this.bonusNumber = bonusNumber;
        this.winLottoNumber = winLottoNumber;
        checkWinLotto();
    }

    private void inspectDuplicationNumber(LottoNumber winLottoNumber, Number bonusNumber) {
        for (Number number : winLottoNumber.numbers()) {
            compareNumbers(number, bonusNumber);
        }
    }

    private void compareNumbers(Number number, Number bonusNumber) {
        if (number.number() == bonusNumber.number()) {
            throw new IllegalArgumentException("중복된 1등 로또 번호가 있습니다.");
        }
    }


    public Rank duplicationLottoRank(LottoNumber lottoNumber) {
        duplicationCount = 0;
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
