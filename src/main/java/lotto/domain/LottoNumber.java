package lotto.domain;

import java.util.List;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(GenerateLottoNumberStrategy generateLottoNumberStrategy) {
        this.numbers = generateLottoNumberStrategy.generate();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
