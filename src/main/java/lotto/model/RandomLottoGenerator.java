package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int LOTTO_SIZE = 6;

    public RandomLottoGenerator() {
    }

    @Override
    public Lottos get() {
        return new Lottos(getLottoNumbers());
    }

    private List<Integer> getLottoNumbers() {
        List<Integer> numbers = initNumbers();

        List<Integer> lottos = new ArrayList<>(LOTTO_SIZE);
        for (int i = 0; i < LOTTO_SIZE; i++) {
            Collections.shuffle(numbers);
            lottos.add(numbers.remove(i));
        }
        return lottos;
    }

    private List<Integer> initNumbers() {
        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
