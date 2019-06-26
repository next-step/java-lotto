package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final List<Integer> rottoAllNumbers = createAllNumberOfRotto();

    private final List<Integer> numbers;

    Lotto() {
        this.numbers = createNumbers();
    }

    private static List<Integer> createAllNumberOfRotto() {
        return IntStream.range(1,46)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<Integer> createNumbers() {
        Collections.shuffle(rottoAllNumbers);
        return new ArrayList<>(rottoAllNumbers.subList(0, 6));
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int computeCountOfNumberExist(List<Integer> findNumbers) {
        return (int) findNumbers.stream()
                .filter(this.numbers::contains)
                .count();
    }
}
