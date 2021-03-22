package lotto.domain;

import lotto.dto.LottoNumber;
import lotto.dto.WinningNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoPlay.LOTTO_LENGTH;

public class LottoNumbers {

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new HashSet<>(lottoNumbers);

        if (this.lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public boolean isContain(LottoNumber bonusNumber) {
        boolean trueOrFalse = false;

        for (LottoNumber lottoNumber : lottoNumbers) {
            trueOrFalse = isMatching(lottoNumber, bonusNumber.getLottoNumber(), trueOrFalse);
        }

        return trueOrFalse;
    }

    public boolean isMatching(LottoNumber lottoNumber, int bonusNumber, boolean trueOrFalse) {
        if (bonusNumber == lottoNumber.getLottoNumber()) {
            trueOrFalse = true;
        }

        return trueOrFalse;
    }

    public int countMatchNumber(WinningNumber winningNumber) {
        return lottoNumbers.stream()
                .mapToInt(lottoNumber -> matchNumber(winningNumber.getWinningNumber(), lottoNumber))
                .sum();
    }

    public int matchNumber(List<LottoNumber> winningNumber, LottoNumber lottoNumber) {
        if (winningNumber.contains(lottoNumber)) {
            return 1;
        }

        return 0;
    }
}
