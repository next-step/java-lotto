package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final Set<LottoNumber> lottoNumbers) {
        valid(lottoNumbers);
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
    }

    private void valid(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public Lotto(final List<LottoNumber> lottoNumbers) {
        this(Set.copyOf(lottoNumbers));
    }

    public Lotto(final int... numbers) {
        this(Arrays.stream(numbers)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    public Lotto(final String numbers) {
        this(
                Arrays.stream(numbers.split(","))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray()
        );
    }

    public String getLottoNumberInfo() {
        return lottoNumbers.stream()
                .map(LottoNumber::getValue)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        Set<LottoNumber> matchingNumbers = new TreeSet<>(this.lottoNumbers);
        matchingNumbers.retainAll(winningLotto.lottoNumbers);
        return matchingNumbers.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;

        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }
}
