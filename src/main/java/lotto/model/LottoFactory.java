package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

    private LottoFactory() {
    }

    public static List<Lotto> generateLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateRandomSixNumber()));
        }
        return lottos;
    }

    public static List<Integer> generateRandomSixNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
