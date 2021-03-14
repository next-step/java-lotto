package study.calculator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 숫자를 관리 할 일급 컬렉션
 */
public class Numbers {

    private final List<Integer> numbers;

    public Numbers(String[] split) {
        numbers = getIntegers(split);
    }

    private List<Integer> getIntegers(String[] split) {
        return Arrays.stream(split)
                .filter(Validator::isNumeric)
                .map(Integer::parseInt)
                .collect(toList());
    }

    public static Numbers of(String text) {
        String[] split = text.split(",|:");
        return new Numbers(split);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
