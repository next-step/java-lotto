package lotto.domain;

import lotto.dto.LottoNumber;
import lotto.dto.WinningNumber;

import java.util.*;

import static lotto.domain.LottoPlay.LOTTO_LENGTH;

public class LottoNumbers {

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);

        if (this.lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

        if (this.lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public boolean isContain(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
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
