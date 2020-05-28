package study.calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private List<Number> numbers;

    public Numbers(String[] strings) {
        if(Objects.isNull(strings)) {
            throw new IllegalArgumentException();
        }

        numbers = createNumbers(strings);
    }

    private List<Number> createNumbers(String[] strings) {
        List<Number> numbers = new ArrayList<>();

        for(String str : strings) {
            numbers.add(new Number(str));
        }

        // numbers = Arrays.stream(strings).map(this::getIntFromString).collect(Collectors.toList());

        return numbers;
    }

    public int sum() {
        return numbers.stream().mapToInt(Number::getValue).sum();
    }
}
