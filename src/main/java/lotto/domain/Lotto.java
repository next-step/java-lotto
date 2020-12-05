package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.NumberPool;

public final class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final List<Integer> numbers) {
        this.lottoNumbers = new HashSet<>(intToLottoNumber(numbers));
    }

    public Lotto() {
        this.lottoNumbers = NumberPool.getLottoNumbers();
    }

    public List<LottoNumber> getNumbers() {
        final List<LottoNumber> numbers = new ArrayList<>(lottoNumbers);
        numbers.sort(Comparator.comparingInt(LottoNumber::getNumber));
        return numbers;
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private List<LottoNumber> intToLottoNumber(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
