package step1;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수를 입력할 수 없습니다.";
    private static final Integer INITIAL_ANSWER = 0;

    private List<Integer> numbers = new ArrayList<>();

    public Numbers(String[] strings) {
        for(String string : strings) {
            Integer number = Integer.parseInt(string);

            assertNegative(number);

            numbers.add(number);
        }
    }

    public Numbers(Integer[] numberArray) {
        for(Integer number : numberArray) {
            assertNegative(number);

            numbers.add(number);
        }
    }

    private void assertNegative(Integer number) {
        if(number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
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
