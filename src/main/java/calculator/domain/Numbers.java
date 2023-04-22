package calculator.domain;

import static java.util.Arrays.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Numbers {

    private final int[] numbers;

    private static final String EMPTY_MSG = "연산 가능한 숫자가 없습니다.";

    public Numbers(int[] numbers) {
        if(emptyArray(numbers)) {
            throw new IllegalArgumentException(EMPTY_MSG);
        }
        this.numbers = numbers;
    }

    public Numbers(String[] numbers) {
        this(nullSafeIntArr(numbers));

    }

    private static int [] nullSafeIntArr(String [] numbers) {
        if(numbers == null) {
            return new int[0];
        }
        return stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private boolean emptyArray(int[] array) {
        return array == null || array.length == 0;
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
        return Arrays.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}
