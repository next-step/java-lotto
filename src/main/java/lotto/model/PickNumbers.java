package lotto.model;

import java.util.Collections;
import java.util.List;

public class PickNumbers extends LottoNumbers{

    private List<Integer> numbers;

    public PickNumbers(List<Integer> numbers) {
        super(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public boolean contains(Integer winningNumber) {
        return this.numbers.contains(winningNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();

    }
}
