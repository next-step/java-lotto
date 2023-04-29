package lotto.util;


import java.util.List;

import static lotto.constants.Constants.MAX_NUMBER;
import static lotto.constants.Constants.MIN_NUMBER;
import static lotto.constants.Constants.REQUIRED_LOTTO_NUMBERS;

public class LottoValidationUtils {

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 서로 다른 " + REQUIRED_LOTTO_NUMBERS + " 개의 번호로 구성되어야 합니다.");
        }

        for (int number : numbers) {
            validateNumber(number);
        }
    }

    public static void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("잘못된 숫자: " + number + " - 숫자는 " + MIN_NUMBER + " 과 " + MAX_NUMBER + " 사이여야 합니다");
        }
    }

}