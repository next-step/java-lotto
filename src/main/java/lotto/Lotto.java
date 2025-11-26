package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
        this.numbers = numbers;
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다");
        }
    }

    private static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 한다");
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkRange(number);
        }
    }

    private static void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 범위의 숫자여야 한다");
        }
    }
}
