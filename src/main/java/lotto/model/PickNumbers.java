package lotto.model;

import java.util.List;

public class PickNumbers extends LottoNumbers{

    private List<Integer> numbers;

    public PickNumbers(List<Integer> numbers) {
        super(numbers);
        this.numbers = numbers;
    }

    public int compare(WinningNumbers winningNumber) {
        return 3;
    }
}
