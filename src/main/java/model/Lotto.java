package model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;
    private static final int LOTTO_SIZE = 6;
    private static final String INVALID_LOTTO_SIZE = "하나의 로또엔 6개의 숫자여야 한다.";

    public Lotto(List<Integer> numbers) {
        checkValidLotto(numbers);
        this.lottoNumbers = toLottoNumber(numbers);
    }

    private List<LottoNumber> toLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void checkValidLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    public long countWinningNumbers(Lotto lotto) {
        return lottoNumbers.stream()
                .filter(lotto.lottoNumbers::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
