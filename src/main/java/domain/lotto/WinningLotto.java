package domain.lotto;

import java.util.List;

public class WinningLotto {
    public final List<Integer> winningNumbers;

    public WinningLotto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    boolean hasSameNumbersWithSameOrder(List<Integer> numbers) {
        boolean result = true;
        for (int i = 0; i < numbers.size(); i++) {
            result =  areSame(numbers.get(i), winningNumbers.get(i));
        }
        return result;
    }

    private boolean areSame(int x, int y) {
        return x == y;
    }
}
