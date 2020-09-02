package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private static final String INVALID_LOTTO_SIZE = "로또 개수는 6개 입니다.";

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    public static Lotto of(LottoNumberGenerator lottoNumberGenerator) {
        return new Lotto(lottoNumberGenerator.generator(LOTTO_SIZE));
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public int getMatchCountByWinningLotto(WinningLotto winningLotto) {
        return (int) winningLotto.getWinningNumbers().stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "["
                + lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(","))
                + "]";
    }
}
