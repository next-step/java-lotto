package step2.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static step2.game.Number.createVerifiedNumbers;

public class LottoGame {
    static final int MAX_NUMBER = 45;
    static final int NUMBER_COUNT = 6;
    static final int MIN_NUMBER = 1;
    private static final List<Number> balls = createVerifiedNumbers();

    private static final String DELIMITER = ", ";
    private static final int START_INDEX = 0;

    private List<Number> numbers;

    public LottoGame() {
        numbers = pickRandomNumbers();
    }

    public LottoGame(String manualNumbers) {
        this.numbers = Arrays.stream(manualNumbers.trim().split(","))
                .map(num -> Integer.parseInt(num.trim()))
                .map(num -> Number.valueOf(num))
                .collect(toList());
    }

    public String toString() {
        return numbers.stream().map(Number::toString).reduce((o1, o2) -> o1 + DELIMITER + o2)
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<Number> pickRandomNumbers() {
        Collections.shuffle(balls);
        List<Number> number = new ArrayList<>(balls.subList(START_INDEX, NUMBER_COUNT));
        number.sort(Number::compareTo);
        return number;
    }

    int matchWinningNumberCount(WinningLotto winningLotto) {
        return Math.toIntExact(numbers.stream().filter(winningLotto::contains).count());
    }

    boolean containsBonus(WinningLotto winningLotto) {
        return winningLotto.hasBonus(numbers);
    }
}
