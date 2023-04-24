package calculator.domain;

import static java.util.Arrays.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class Numbers {

    private static final String EMPTY_MSG = "연산 가능한 숫자가 없습니다.";

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        if(emptyArray(numbers)) {
            throw new IllegalArgumentException(EMPTY_MSG);
        }
        this.numbers = numbers;
    }

    private boolean emptyArray(List<Integer> integers) {
        return integers == null || integers.size() == 0;
    }

    public Queue<Integer> numbers() {
        Queue<Integer> numbers = new LinkedList<>();
        for (int number : this.numbers) {
            numbers.offer(number);
        }
        return numbers;
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
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
