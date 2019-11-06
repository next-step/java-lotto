package step2.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static step2.Util.LottoUtil.*;

public class Game {
    private static final List<Integer> balls = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
            .boxed().collect(toList());

    private static final String DELIMITER = ", ";
    private static final int START_INDEX = 0;

    private List<Integer> numbers;

    public Game() {
        numbers = getSortedUniques();
    }

    public String getNumbers() {
        return numbers.stream().map(String::valueOf).reduce((o1, o2) -> o1 + DELIMITER + o2)
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<Integer> getSortedUniques() {
        Collections.shuffle(balls);
        List<Integer> number = new ArrayList<>(balls.subList(START_INDEX, LOTTO_NUMBER_COUNT));
        number.sort(Integer::compareTo);
        return number;
    }

    int getIncludingWinningNumber(WinningNumbers winningNumbersNumber) {
        return Math.toIntExact(numbers.stream().filter(winningNumbersNumber::contains).count());
    }
}
