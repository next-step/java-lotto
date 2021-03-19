package step2.dto;

import step2.domain.God;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int UPPER_BOUND = 45;
    private static final int COUNT = 6;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException();
        this.numbers = numbers;
    }

    public Lotto() {
        this(God.issueNumbers(UPPER_BOUND, COUNT));
    }

    public Lotto(String values) {
        this(Arrays.stream(values.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
