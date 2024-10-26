package lotto.utility;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String NUMBERS_FORMAT = "^\\d{1,2}(,\\s\\d{1,2}){5}$";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private Validator() {
    }

    public static void isValidFormat(String lastWeekWinningNumbers) {
        if (!lastWeekWinningNumbers.matches(NUMBERS_FORMAT)) {
            throw new IllegalArgumentException("잘못된 입력형식입니다. 1, 2, 3, 4, 5, 6과 같은 형태로 입력해주세요");
        }
    }

    public static void isValidNumber(int number) {
        checkNumberRange(number);
    }

    public static void isValidNumbers(List<Integer> numbers) {
        checkNumberCount(numbers);

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            checkNumberRange(number);
            checkDuplicateNumber(number, uniqueNumbers);

        }
    }

    private static void checkNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또의 수는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + "까지의 숫자만 가능합니다.");
        }
    }

    private static void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 숫자의 개수는 반드시 6개여야 합니다.");
        }
    }

    private static void checkDuplicateNumber(Integer number, Set<Integer> uniqueNumbers) {
        if (!uniqueNumbers.add(number)) {
            throw new IllegalArgumentException("중복된 당첨번호가 입력되었습니다.");
        }
    }

}
