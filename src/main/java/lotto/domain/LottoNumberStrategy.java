package lotto.domain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 21:53
 */
public class LottoNumberStrategy implements RandomGenerateStrategy {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final Random random = new Random();
    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");
    private static final String DELIMITER = ",";

    @Override
    public List<Integer> generateLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            numbers.add(getRandomNumberRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM));
        }
        return numbers;
    }

    public static void validateLottoNumber(String winningNumber) {
        if (winningNumber == null || winningNumber.isEmpty()) {
            throw new InputMismatchException("null, 빈 공백은 입력이 불가능합니다.");
        }
        String[] numbers = winningNumber.split(DELIMITER);
        for (String number : numbers) {
            if (!isNumber(number)) {
                throw new InputMismatchException("로또는 숫자만 가능합니다.");
            }

            if (!isLottoNumberRange(Integer.parseInt(number))) {
                throw new InputMismatchException("로또는 1-45 숫자만 입력이 가능합니다.");
            }
        }
        if (isLottoNumberSize(numbers.length)) {
            throw new InputMismatchException("로또는 6개의 숫자로 구성되어야 합니다.");
        }
    }

    private static boolean isLottoNumberSize(int lottoSize) {
        return lottoSize == LOTTO_NUMBER_SIZE;
    }

    private static boolean isLottoNumberRange(int number) {
        checkMinMax(LOTTO_MIN_NUM, LOTTO_MAX_NUM);
        return number >= LOTTO_MIN_NUM && number <= LOTTO_MAX_NUM;
    }

    private static int getRandomNumberRange(int min, int max) {
        checkMinMax(min, max);
        return random.nextInt((max - min) + 1) + min;
    }

    private static void checkMinMax(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("최소값이 최대값보다 크거나 같습니다.");
        }
    }

    public static boolean isNumber(String number) {
        return number != null && NUMERIC.matcher(number).matches();
    }
}
