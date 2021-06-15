package lotto.domain;

import java.util.Arrays;

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

        int[] numbers = Arrays.asList(inputLastWonLottoNumberString.split(","))
                .stream().mapToInt(Integer::parseInt).toArray();
        winningLottoNumbers = LottoNumbers.generateManualOf(numbers);
        return winningLottoNumbers;
    }

    public boolean containsMain(LottoNo lottoNo) {
        return winningLottoNumbers.contains(lottoNo);
    }

    public boolean containsBonus(LottoNo targetLottoNo) {
        if (bonusNumber.equals(targetLottoNo))
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
        if (containsMain(targetLottoNo))
            return sameNumberCount + 1;
        return sameNumberCount;
    }

    private boolean setTrueIfSameBonusNumber(LottoNo targetLottoNo, boolean isSameBonusNumber) {
        if (isSameBonusNumber == true)
            return true;

        if (containsBonus(targetLottoNo))
            return true;

        return false;
    }

}
