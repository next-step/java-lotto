package util;

import java.util.Arrays;
import java.util.List;

public class LottoValidator {
    private static final String NUMBER_DELIMITER = ", ";

    public static void checkDuplicateNumber(List<Integer> numbers) {
        long uniqueLength = numbers.stream()
                .distinct()
                .count();

        if(uniqueLength != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자를 가질 수 없습니다.");
        }
    }

    public static void checkWinningNumberValidate(String winningNumbers) {
        checkEmptyString(winningNumbers);
        String[] splitNumber = winningNumbers.split(NUMBER_DELIMITER);
        checkNumberLength(splitNumber);
        Arrays.stream(splitNumber)
                .map(Integer::new)
                .forEach(LottoValidator::checkLottoRange);
    }

    private static void checkEmptyString(String winningNumbers) {
        if(winningNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }

    private static void checkNumberLength(String[] splitNumber) {
        if(splitNumber.length != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개입니다.");
        }
    }

    private static void checkLottoRange(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 범위는 1 ~ 45 입니다.");
        }
    }

}
