package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public class LottoNumberMachine {
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public static List<Integer> provideLottoNumber() {
        Collections.shuffle(LOTTO_NUMBERS); // 셔플
        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBERS.subList(0, LOTTO_LENGTH)); // 로또 자동
        sort(numbers); // 오름차순
        return numbers;
    }
}
