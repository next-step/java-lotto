package lotto;

import java.util.List;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoMatchResult match(List<Integer> winningNumbers) {
        int matched = 0;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matched++;
            }
        }

        return new LottoMatchResult(matched);
    }

}
