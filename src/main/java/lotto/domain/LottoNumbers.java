package lotto.domain;

import lotto.dto.LottoNumber;

import java.util.List;

public class LottoNumbers {

    private static final int LOTTO_LENGTH = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }

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
        return lottoNumbers.stream()
                .mapToInt(lottoNumber -> matchNumber(winningNumber, lottoNumber))
                .sum();
    }

    public int matchNumber(List<Integer> winningNumber, LottoNumber lottoNumber) {
        if (winningNumber.contains(lottoNumber.getLottoNumber())) {
            return 1;
        }

        return 0;
    }
}
