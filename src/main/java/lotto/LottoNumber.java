package lotto;

import java.util.List;

public class LottoNumber {

    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public long matchNumberCount(List<Integer> winnerNumbers) {
        return winnerNumbers.stream().filter(numbers::contains).count();
    }
}
