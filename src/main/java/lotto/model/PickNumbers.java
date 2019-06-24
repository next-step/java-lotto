package lotto.model;

import java.util.List;

public class PickNumbers extends LottoNumbers{

    private List<Integer> numbers;

    public PickNumbers(List<Integer> numbers) {
        super(numbers);
        this.numbers = numbers;
    }

    public int compare(WinningNumbers winningNumber) {
        return Math.toIntExact(this.numbers.stream()
                .filter(number -> winningNumber.contains(number))
                .count());
    }
}
