package step1.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<String> numberList) {
        List<Number> numbers = new ArrayList<>();
        for (String number : numberList) {
            numbers.add(new Number(number));
        }
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Number sum() {
        return numbers.stream().reduce((x, y) -> x.add(y)).get();
    }
}
