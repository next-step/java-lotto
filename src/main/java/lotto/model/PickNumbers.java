package lotto.model;

import java.util.List;

public class PickNumbers extends LottoNumbers{

    private List<Integer> numbers;

    public PickNumbers(List<Integer> numbers) {
        super(numbers);
        this.numbers = numbers;
    }

    public long compare(WinningNumbers winningNumber) {
        return this.numbers.stream()
                .filter(number -> winningNumber.contains(number))
                .count();
    }
}
