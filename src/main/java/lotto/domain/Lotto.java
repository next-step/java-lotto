package lotto.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int DEFAULT_QUANTITY = 6;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> numbers) {
        this.lottoNumbers = new LinkedHashSet<>();
        lottoNumbers.addAll(numbers);
        validateSize(lottoNumbers);
    }

    public static Lotto from(List<Integer> numbers) {
        List<LottoNumber> list = numbers
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new Lotto(list);
    }

    private static void validateSize(Set<LottoNumber> numbers) {
        if (isSizeNotEqualsSix(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isSizeNotEqualsSix(Set<LottoNumber> numbers) {
        return numbers == null || numbers.size() != DEFAULT_QUANTITY;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public int matchedCount(Lotto lotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            count = addCount(lotto, count, lottoNumber);
        }

        return count;
    }

    private static int addCount(Lotto lotto,
                                int count,
                                LottoNumber lottoNumber) {
        if (lotto.contains(lottoNumber)) {
            count++;
        }
        return count;
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
        return lottoNumbers.toString();
    }

}
