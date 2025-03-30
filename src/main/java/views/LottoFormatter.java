package views;

import java.util.List;

public class LottoFormatter {

    private final List<Integer> numbers;

    public LottoFormatter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String numbersAsString() {
        return numbers.toString();
    }
}
