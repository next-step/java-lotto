package lotto.domain;

import lotto.common.Constant;
import lotto.common.MessageCode;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumbers {
    private List<LottoNo> winningLottoNumbers;
    private LottoNo bonusNumber;

    public WinningLottoNumbers(String inputWinningLottoNumberString, String inputBonusNumber) {
        winningLottoNumbers = new ArrayList<LottoNo>();
        winningLottoNumbers = parsingInputString(inputWinningLottoNumberString);

        bonusNumber = new LottoNo(Integer.parseInt(inputBonusNumber));
    }

    private List<LottoNo> parsingInputString(String inputLastWonLottoNumberString) {
        String[] numbers = inputLastWonLottoNumberString.split(",");
        for (int i = 0; i < numbers.length; i++) {
            winningLottoNumbers.add(new LottoNo(Integer.parseInt(numbers[i])));
        }
        return winningLottoNumbers;
    }

/*    private int validateNumber(String splitNumber) {
        if (!isNumeric(splitNumber))
            throw new RuntimeException(MessageCode.INVALID_LOTTO_NUMBER_TYPE.message());

        int number = Integer.parseInt(splitNumber);
        if (number > Constant.MAX_LOTTO_NUMBER.value())
            throw new RuntimeException(MessageCode.INVALID_LOTTO_NUMBER_RANGE.message());

        return number;
    }*/

    private boolean isNumeric(String splitNumber) {
        return splitNumber.matches("[+-]?\\d*(\\.\\d+)?");
    }

    public boolean containsMain(int number) {
        return winningLottoNumbers.contains(new LottoNo(number));
    }

    public boolean containsBonus(int number) {
        if (bonusNumber.lottNo() == number)
            return true;

        return false;
    }

    public List<LottoNo> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public Integer getBonusNumber() {
        //return bonusNumber;
        return 0;
    }

    public ResultScoreEnum matchLottoNumbers(LottoNumbers lottoNumbers) {
        int sameNumberCount = 0;
        boolean isSameBonusNumber = false;

        for (LottoNo lottoNo : lottoNumbers.lottoNumbers()) {
            sameNumberCount = increaseIfSameNumber(lottoNo, sameNumberCount);
            isSameBonusNumber = setTrueIfSameBonusNumber(lottoNo, isSameBonusNumber);
        }

        MatchStatusOfALotto matchStatusOfALotto = new MatchStatusOfALotto(sameNumberCount, isSameBonusNumber);

        return matchStatusOfALotto.getResultScore();
    }

    private int increaseIfSameNumber(LottoNo targetLottoNo, int sameNumberCount) {
        if (containsMain(targetLottoNo.lottNo()))
            return sameNumberCount+1;
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
