package step2;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class LottoNumberGenerator {
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public static List<Integer> provideLottoNumbers() {
        shuffle(LOTTO_NUMBERS); // 셔플
        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBERS.subList(0, LOTTO_LENGTH)); // 로또 자동
        sort(numbers); // 오름차순
        return numbers;
    }
}
