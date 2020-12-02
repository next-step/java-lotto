package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.NumberPool;

public class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = new HashSet<>(intToLottoNumber(numbers));
    }

    public Lotto() {
        this.lottoNumbers = NumberPool.getLottoNumbers();
    }

    private List<LottoNumber> intToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Set<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
