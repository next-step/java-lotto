package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException();
        this.numbers = numbers;
    }

    public Lotto() {
        this(God.issueNumbers(45, 6));
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
