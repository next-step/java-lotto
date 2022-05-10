package autolotto.domain;

import autolotto.exception.LottoException;
import autolotto.exception.LottoExceptionCode;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBER = 6;
    private final Set<LottoNumber> lottoNumbers;

    public static LottoNumbers of(Set<Integer> lottoNumbers) {
        if (isNotLottoSize(lottoNumbers)) {
            throw new LottoException(LottoExceptionCode.INVALID_LOTTO_NUMBER_COUNT, lottoNumbers.toString());
        }
        return new LottoNumbers(
                lottoNumbers.stream()
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet()));
    }

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private static boolean isNotLottoSize(Set<Integer> lottoNumbers) {
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

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
