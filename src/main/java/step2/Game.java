package step2;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static step2.LottoUtil.*;

public class Game {
    private static final List<Integer> balls = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
            .boxed().collect(toList());

    private List<Integer> numbers;

    public Game() {
        numbers = getSortedUniques();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private List<Integer> getSortedUniques() {
        Collections.shuffle(balls);
        List<Integer> number = balls.subList(0, LOTTO_NUMBER_COUNT);
        number.sort(Integer::compareTo);
        return number;
    }
}
