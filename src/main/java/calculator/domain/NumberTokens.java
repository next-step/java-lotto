package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberTokens {
    List<Integer> numbers;

    public NumberTokens(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
