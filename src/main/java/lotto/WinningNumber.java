package lotto;

import java.util.List;

public class WinningNumber {

    private final LottoRow winningNumber;

    public WinningNumber(List<Integer> numbers) {
        this.winningNumber = new LottoRow(numbers);
    }
}
