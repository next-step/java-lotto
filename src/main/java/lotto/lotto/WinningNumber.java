package lotto.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumber {
    private final Set<LottoNumber> numbers;

    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public Set<LottoNumber> numbers() {
        return numbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}