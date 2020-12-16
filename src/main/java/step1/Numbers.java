package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수를 입력할 수 없습니다.";
    private static final Integer INITIAL_ANSWER = 0;

    private List<Integer> numbers = new ArrayList<>();

    public Numbers(String[] strings) {
        List<Integer> newNumbers = Arrays.stream(strings)
                .map(this::assertNegative)
                .collect(Collectors.toList());

        numbers.addAll(newNumbers);
    }

    public Numbers(Integer[] numberArray) {
        List<Integer> newNumbers = Arrays.stream(numberArray)
                .map(this::assertNegative)
                .collect(Collectors.toList());

        numbers.addAll(newNumbers);
    }

    private int assertNegative(String string) {
        Integer number = Integer.parseInt(string);

        if(number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }

        return number;
    }

    private int assertNegative(int number) {
        if(number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }

        return number;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer addAll() {
        int result = INITIAL_ANSWER;

        for(Integer number: numbers) {
            result = result + number;
        }

        return result;
    }
}
