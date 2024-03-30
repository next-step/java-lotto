package lottogame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<LottoNumber> numbers;

    public Lottos(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public boolean match(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
