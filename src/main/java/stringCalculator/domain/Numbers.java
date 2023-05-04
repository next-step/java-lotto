package stringCalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private static List<Integer> numbers = new ArrayList<>();

    private final String REGEX = "[0123456789]+";

    public Numbers() {};

    public Numbers(String s) {
        numbers.add(validNumber(s));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int validNumber(String inputNumber) {
        if(!REGEX.contains(inputNumber) || inputNumber.isBlank()) {
            throw new IllegalArgumentException("숫자가 입력되어야 할 자리에 숫자를 입력해주세요");
        }
        return Integer.parseInt(inputNumber);
    }

}
