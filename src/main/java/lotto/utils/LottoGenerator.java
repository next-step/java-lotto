package lotto.utils;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> generateLottos(int size) {

        List<Lotto> lottos = new ArrayList<>();
        for (int cnt = 0; cnt < size; cnt++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private static Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int num = 1; num <= 45; ++num) {
            numbers.add(num);
        }
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, 6));
    }
}
