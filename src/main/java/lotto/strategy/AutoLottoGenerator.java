package lotto.strategy;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {

    public static final int FIRST_INDEX = 0;
    public static final int LAST_INDEX = 6;
    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;

    @Override
    public List<Lotto> generate(final int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generate());
        }
        return lottos;
    }

    private Lotto generate() {
        List<Integer> numbers = numbers();
        Collections.shuffle(numbers);
        List<Integer> sixNumbers = sixNumbers(numbers);
        Collections.sort(sixNumbers);
        return new Lotto(sixNumbers);
    }

    private static List<Integer> sixNumbers(final List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = FIRST_INDEX; i < LAST_INDEX; i++) {
            result.add(numbers.get(i));
        }
        return result;
    }

    private static List<Integer> numbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = FIRST_NUMBER; i <= LAST_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
