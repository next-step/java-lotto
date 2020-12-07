package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import lotto.NumberPool;

public final class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final List<Integer> numbers) {
        this.lottoNumbers = Collections.unmodifiableSet(listToTreeSet(numbers));
    }

    public Lotto() {
        this.lottoNumbers = NumberPool.getLottoNumbers();
    }

    public Set<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    public int countContainNumbers(Lotto lotto) {
        return (int) lottoNumbers.stream().filter(lotto::contains).count();
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private Set<LottoNumber> listToTreeSet(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparingInt(LottoNumber::getNumber))
                        )
                );
    }
}
