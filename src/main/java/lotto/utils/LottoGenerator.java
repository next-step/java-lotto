package lotto.utils;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_MIN_VALUE = 1;
    private static final int LOTTO_MAX_VALUE = 45;
    private static final int LOTTO_SIZE = 6;

    public static List<Lotto> generateLottos(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int cnt = 0; cnt < size; cnt++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private static Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int num = LOTTO_MIN_VALUE; num <= LOTTO_MAX_VALUE; ++num) {
            numbers.add(num);
        }

        Collections.shuffle(numbers);
        numbers = numbers.subList(0, LOTTO_SIZE);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }
}
