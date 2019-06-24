package lotto.model;

import java.util.List;

public class WinningNumbers extends LottoNumbers{


    private List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        super(numbers);
        this.numbers = numbers;
    }

    public boolean contains(Integer pickNumber) {
        return this.numbers.contains(pickNumber);
    }
}
