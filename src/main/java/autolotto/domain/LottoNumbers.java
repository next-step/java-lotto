package autolotto.domain;

import autolotto.exception.LottoException;
import autolotto.exception.LottoExceptionCode;

import java.util.Set;

public class LottoNumbers {
    private static final int LOTTO_NUMBER = 6;
    private Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (isNotLottoSize(lottoNumbers)) {
            throw new LottoException(LottoExceptionCode.INVALID_LOTTO_NUMBER_COUNT, lottoNumbers.toString());
        }
        this.lottoNumbers = lottoNumbers;
    }

    private boolean isNotLottoSize(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != LOTTO_NUMBER;
    }

    public int match(WinningLotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers
                .contains(number);
    }

    public boolean checkBonus(WinningLotto winningLotto) {
        return lottoNumbers.contains(winningLotto.getBonusBall());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
