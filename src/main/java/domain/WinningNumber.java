package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public WinningNumber(String numbers) {
        this(parseToInteger(parseToString(numbers)));
    }

    private static List<Integer> parseToInteger(List<String> numbers) {
        validate(numbers);
        List<Integer> createNumbers = new ArrayList<>();
        for (String number : numbers) {
            createNumbers.add(Integer.parseInt(number));
        }
        return createNumbers;
    }

    private static List<String> parseToString(String numbers) {
        return Arrays.stream(numbers.split(",", -1))
                .map(String::trim)
                .toList();
    }

    private static void validate(List<String> numbers) {
        for (String number : numbers) {
            validateNumber(number);
            validateNumeric(number);
        }
    }

    private static void validateNumber(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("null 이거나 공백은 불가능합니다.");
        }
    }

    private static void validateNumeric(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRange(number);
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }

        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    private static void validateRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이여야 합니다.");
        }
    }


    public boolean contains(int number) {
        return numbers.contains(number);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningNumber)) {
            return false;
        }
        WinningNumber that = (WinningNumber) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }
}
