package step2.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validation {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private Validation() {
    }

    public static void rangeOfNumber(int number) {
        if (isValidNumber(number)) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }

    public static void validComponent(List<Integer> numbers) {
        if (isValidSize(numbers)) {
            throw new IllegalArgumentException("입력한 로또 번호의 개수가 올바르지 않습니다.");
        }

        Set<Integer> store = new HashSet<>(numbers);
        if (isDuplication(numbers, store)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private static boolean isValidSize(List<Integer> numbers) {
        return numbers.size() % LOTTO_SIZE != 0;
    }

    private static boolean isDuplication(List<Integer> numbers, Set<Integer> store) {
        return numbers.size() != store.size();
    }

    private static boolean isValidNumber(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }
}
