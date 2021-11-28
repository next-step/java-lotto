package step1.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {
    List<Number> numbers;

    public Numbers(String[] numbers) {
        try {
            this.numbers = Arrays.stream(numbers)
                    .map(n -> new Number(Integer.parseInt(n)))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("입력 숫자 오류");
        }
    }

    public List<Number> getList() {
        return Collections.unmodifiableList(numbers);
    }

    public Number sum() {
        return new Number(numbers.stream()
                .mapToInt(Number::getNumber)
                .sum()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
