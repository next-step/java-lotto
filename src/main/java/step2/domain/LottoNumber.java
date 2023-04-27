package step2.domain;

import java.util.List;

public class LottoNumber {

    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> get() {
        return this.numbers;
    }
}
