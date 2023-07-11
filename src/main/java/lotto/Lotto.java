package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 번호를 가져야합니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
