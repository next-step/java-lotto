package lotto.domain;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private static final String SIZE_ERROR = "로또는 " + LOTTO_SIZE + "개의 번호여야 합니다.";

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final Set<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(final Set<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = convertToLottoNumber(numbers);
        return new Lotto(lottoNumbers);
    }

    private void validateSize(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public int countMatchCount(final Lotto winningNumber) {
        return (int) lottoNumbers.stream()
                .filter(winningNumber.lottoNumbers::contains)
                .count();
    }

    public boolean hasNumber(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private static Set<LottoNumber> convertToLottoNumber(final Set<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
    }
}
