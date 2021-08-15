package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWinningNumbers {

    private final List<Integer> winningNumbers = new ArrayList<>();

    public void selectWinningNumbers(final List<Integer> numbers) {
        winningNumbers.addAll(numbers);
    }

    public List<Integer> getWinningNumber() {
        return Collections.unmodifiableList(winningNumbers);
    }

}
