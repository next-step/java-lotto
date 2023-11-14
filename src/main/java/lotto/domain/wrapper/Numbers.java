package lotto.domain.wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private List<Number> numbers = new ArrayList<>();

    public Numbers() {
    }

    public Numbers(List<Integer> inputs) {
        inputs.forEach(input -> numbers.add(new Number(input)));
    }

    public List<Integer> numbers() {
        return numbers.stream()
            .map(Number::number)
            .collect(Collectors.toUnmodifiableList());
    }

    public int countMatchingNumbers(Numbers target) {
        return (int) numbers.stream()
            .filter(target::contains)
            .count();
    }

    private boolean contains(Number target) {
        return this.numbers.contains(target);
    }
}
