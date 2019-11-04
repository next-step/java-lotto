package calc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Numbers {

    private static final String ILLEGAL_INPUT = "음수가 발견되었습니다.";
    private final Predicate<Integer> isNegative = i -> i < 0;
    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = checkNumbers(numbers);
    }

    public Numbers(String[] numbers) {
        List<Integer> inputNumbers = Arrays.stream(numbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        this.numbers = checkNumbers(inputNumbers);
    }

    private List<Integer> checkNumbers(List<Integer> numbers) {
        if (numbers.stream().anyMatch(isNegative)) {
            throw new IllegalArgumentException(ILLEGAL_INPUT);
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int addAll() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Numbers numbers1 = (Numbers) o;

        return numbers != null ? numbers.equals(numbers1.numbers) : numbers1.numbers == null;
    }

    @Override
    public int hashCode() {
        int result = isNegative != null ? isNegative.hashCode() : 0;
        result = 31 * result + (numbers != null ? numbers.hashCode() : 0);
        return result;
    }
}
