package lotto;

import java.util.List;

public class ManualLottoFactory {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static Lotto create(List<Integer> numbers) {
        checkLottoNumbersSize(numbers.size());
        for (int number : numbers) {
            checkNumber(number);
        }

        return new Lotto(numbers);
    }

    private static void checkLottoNumbersSize(int size) {
        if (size != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 숫자 6개 입력해주세요.");
        }
    }

    private static void checkNumber(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("lotto 숫자는 1 ~ 45만 입력 가능힙니다.");
        }
    }
}
