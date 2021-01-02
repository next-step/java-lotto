package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    /**
     * 6자리의 로또 번호 생성
     * @return List<Integer>
     */
    public static List<Integer> makeLotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBERS.subList(0, LOTTO_LENGTH));
        Collections.sort(numbers);

        return numbers;
    }
}
