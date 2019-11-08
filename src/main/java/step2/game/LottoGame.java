package step2.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoGame {
    static final int NUMBER_COUNT = 6;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;

    private static final List<Integer> balls = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed().collect(toList());

    private static final String DELIMITER = ", ";
    private static final int START_INDEX = 0;

    private List<Integer> numbers;

    public LottoGame() {
        numbers = pickRandomNumbers();
    }

    public String toString() {
        return numbers.stream().map(String::valueOf).reduce((o1, o2) -> o1 + DELIMITER + o2)
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<Integer> pickRandomNumbers() {
        Collections.shuffle(balls);
        List<Integer> number = new ArrayList<>(balls.subList(START_INDEX, NUMBER_COUNT));
        number.sort(Integer::compareTo);
        return number;
    }

    int matchWinningNumberCount(WinningLotto winningLotto) {
        return Math.toIntExact(numbers.stream().filter(winningLotto::contains).count());
    }
}
