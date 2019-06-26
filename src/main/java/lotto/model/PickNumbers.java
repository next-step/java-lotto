package lotto.model;

import java.util.Collections;
import java.util.List;

public class PickNumbers extends LottoNumbers {

    private List<Number> numbers;

    public PickNumbers(List<Number> numbers) {
        super(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public boolean contains(Number winningNumber) {
        return this.numbers.contains(winningNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
