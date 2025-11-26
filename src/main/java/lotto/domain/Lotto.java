package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final List<Integer> DEFAULT_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toUnmodifiableList());
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public Lotto() {
        List<Integer> tempNumbers = new ArrayList<>(DEFAULT_NUMBERS);
        Collections.shuffle(tempNumbers);
        numbers = tempNumbers.subList(0, 6);
        Collections.sort(numbers);
    }

    public List<Integer> numbers() {
        return List.copyOf(numbers);
    }
}
