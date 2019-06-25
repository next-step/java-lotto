package lotto.model;

import java.util.List;

public class WinningNumbers extends LottoNumbers{


    private List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        super(numbers);
        this.numbers = numbers;
    }

    public int compare(PickNumbers pickNumbers) {
        return Math.toIntExact(this.numbers.stream()
                .filter(number -> pickNumbers.contains(number))
                .count());
    }
}
