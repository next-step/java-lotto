package lotto.domain;

import java.util.List;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
