package step2.game;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ManualGame implements LottoGame {
    private static final String DELIMITER = ", ";
    private List<Number> numbers;

    public ManualGame(String manualNumbers) {
        this.numbers = Arrays.stream(manualNumbers.trim().split(","))
                .map(num -> Integer.parseInt(num.trim()))
                .map(num -> Number.valueOf(num))
                .collect(toList());
    }

    @Override
    public String toString() {
        return numbers.stream().map(Number::toString).reduce((o1, o2) -> o1 + DELIMITER + o2)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public int matchWinningNumberCount(WinningLotto winningLotto) {
        return Math.toIntExact(numbers.stream().filter(winningLotto::contains).count());
    }

    @Override
    public boolean containsBonus(WinningLotto winningLotto) {
        return winningLotto.hasBonus(numbers);
    }
}
