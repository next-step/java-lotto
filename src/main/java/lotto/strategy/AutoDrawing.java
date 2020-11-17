package lotto.strategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoDrawing extends DrawingStrategy {
    private final static Random random = new Random();

    @Override
    public List<Integer> drawNumbers(int numberCount) {
        List<Integer> numbers;

        do {
            numbers = IntStream.range(0, numberCount)
                    .map(e -> getLottoNumber())
                    .boxed()
                    .collect(Collectors.toList());
        } while (isInvalid(numbers, numberCount));

        Collections.sort(numbers);

        return numbers;
    }

    private int getLottoNumber() {
        return random.nextInt(THRESHOLD) + 1;
    }
}
