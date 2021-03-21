package lotto.dto;

import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isContain(int bonusNumber) {
        boolean trueOrFalse = false;

        for (LottoNumber lottoNumber : lottoNumbers) {
            trueOrFalse = isMatching(lottoNumber, bonusNumber, trueOrFalse);
        }

        return trueOrFalse;
    }

    public boolean isMatching(LottoNumber lottoNumber, int bonusNumber, boolean trueOrFalse) {
        if (bonusNumber == lottoNumber.getLottoNumber()) {
            trueOrFalse = true;
        }

        return trueOrFalse;
    }

    public int countMatchNumber(List<Integer> winningNumber) {
        int count = 0;

        for (LottoNumber lottoNumber : lottoNumbers) {
            count += matchNumber(winningNumber, lottoNumber);
        }
        return count;
    }

    public int matchNumber(List<Integer> winningNumber, LottoNumber lottoNumber) {
        if (winningNumber.contains(lottoNumber.getLottoNumber())) {
            return 1;
        }

        return 0;
    }
}
