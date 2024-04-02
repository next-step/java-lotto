package lottogame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<LottoNumber> numbers;

    public Lottos(List<Number> numbers) {
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public int size() {
        return numbers.size();
    }

    public boolean match(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int match(Lottos lottos) {
        return (int) lottos.numbers.stream()
                .filter(this::match)
                .count();
    }
}
