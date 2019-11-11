package step2.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.game.Number.createVerifiedNumbers;

public class AutoGame implements LottoGame {
    private static final int NUMBER_COUNT = 6;
    private static final List<Number> balls = createVerifiedNumbers();

    private static final int START_INDEX = 0;
    private static final String DELIMITER = ", ";
    private List<Number> numbers;

    public AutoGame() {
        numbers = pickRandomNumbers();
    }

    private List<Number> pickRandomNumbers() {
        Collections.shuffle(balls);
        List<Number> number = new ArrayList<>(balls.subList(START_INDEX, NUMBER_COUNT));
        number.sort(Number::compareTo);
        return number;
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
