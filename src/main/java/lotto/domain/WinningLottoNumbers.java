package lotto.domain;

import java.util.List;

public class WinningLottoNumbers {
    private LottoNumbers winningLottoNumbers;
    private LottoNo bonusNumber;

    public WinningLottoNumbers(String inputWinningLottoNumberString, String inputBonusNumber) {
        winningLottoNumbers = parsingInputString(inputWinningLottoNumberString);
        bonusNumber = new LottoNo(Integer.parseInt(inputBonusNumber));
    }

    public WinningLottoNumbers() {

    }

    public LottoNumbers parsingInputString(String inputLastWonLottoNumberString) {

        String[] numbers = inputLastWonLottoNumberString.split(",");
        winningLottoNumbers = LottoNumbers.generateWinningLottoOf(numbers);
        return winningLottoNumbers;
    }

    public boolean containsMain(int number) {
        return winningLottoNumbers.contains(number);
    }

    public boolean containsBonus(int number) {
        if (bonusNumber.lottNo() == number)
            return true;

        return false;
    }

    public MatchStatusOfALotto matchLottoNumbers(LottoNumbers lottoNumbers) {
        int sameNumberCount = 0;
        boolean isSameBonusNumber = false;

        for (LottoNo lottoNo : lottoNumbers.lottoNumbers()) {
            sameNumberCount = increaseIfSameNumber(lottoNo, sameNumberCount);
            isSameBonusNumber = setTrueIfSameBonusNumber(lottoNo, isSameBonusNumber);
        }

        MatchStatusOfALotto matchStatusOfALotto = new MatchStatusOfALotto(sameNumberCount, isSameBonusNumber);

        return matchStatusOfALotto;
    }

    private int increaseIfSameNumber(LottoNo targetLottoNo, int sameNumberCount) {
        if (containsMain(targetLottoNo.lottNo()))
            return sameNumberCount + 1;
        return sameNumberCount;
    }

    private boolean setTrueIfSameBonusNumber(LottoNo targetLottoNo, boolean isSameBonusNumber) {
        if (isSameBonusNumber == true)
            return true;

        if (containsBonus(targetLottoNo.lottNo()))
            return true;

        return false;
    }

}
