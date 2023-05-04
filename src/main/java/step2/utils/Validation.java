package step2.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private Validation(){}

    public static void rangeOfNumber(int number) {
        if (isValidNumber(number)){
           throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }

    private static boolean isValidNumber(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public static void duplicate(List<Integer> numbers) {
        Set<Integer> store = new HashSet<>(numbers);
        if (isDuplication(numbers, store)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private static boolean isDuplication(List<Integer> numbers, Set<Integer> store) {
        return numbers.size() != store.size();
    }
}
