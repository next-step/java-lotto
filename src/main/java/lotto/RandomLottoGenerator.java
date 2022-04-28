package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RandomLottoGenerator {

    public static final int LOTTO_SIZE = 6;

    private RandomLottoGenerator() {
        throw new AssertionError();
    }

    public static Lottos get() {
        List<Integer> lottos = getLottoNumbers();
        return new Lottos(lottos);
    }

    private static List<Integer> getLottoNumbers() {
        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        List<Integer> lottos = new ArrayList<>(LOTTO_SIZE);
        for (int i = 0; i < LOTTO_SIZE; i++) {
            Collections.shuffle(numbers);
            lottos.add(numbers.remove(i));
        }
        return lottos;
    }
}
