package step3.strategy;

import step3.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNum implements LottoNumStrategy {
    private final int NUMBER_BOUNDARY = 45;
    private final int LOTTO_SIZE = 6;
    private List<Integer> numbers = new ArrayList<>();

    public RandomLottoNum() {
        for (int i = 1; i <= NUMBER_BOUNDARY; i++) {
            numbers.add(i);
        }
    }

    @Override
    public Lotto makeLotto() {
        Collections.shuffle(numbers);
        return Lotto.from(numbers.subList(0, LOTTO_SIZE));
    }
}
