package lotto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int ZERO = 0;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static Lotto createManualLotto(List<Integer> numbers) {
        checkLottoNumbersSize(numbers.size());
        for (int number : numbers) {
            checkNumber(number);
        }

        return new Lotto(numbers);
    }

    public static Lotto createAutoLotto() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> lotto = new ArrayList<>();

        IntStream.range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX).forEach(numbers :: add);
        Collections.shuffle(numbers);

        IntStream.range(ZERO, LOTTO_NUMBERS_SIZE).forEach(i -> lotto.add(numbers.get(i)));
        Collections.sort(lotto);

        return new Lotto(lotto);
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
