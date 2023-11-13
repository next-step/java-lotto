package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER_COUNT = 0;
    private static final int MAX_NUMBER_COUNT = 6;
    private static final List<LottoNumber> numbers;

    static {
        List<LottoNumber> list = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            list.add(LottoNumber.valueOf(i));
        }
        numbers = list;
    }

    @Override
    public List<LottoNumber> create() {
        List<LottoNumber> list = new ArrayList<>(createRandomNumbers());
        Collections.sort(list);

        return List.copyOf(list);

    }

    protected List<LottoNumber> createRandomNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(MIN_NUMBER_COUNT, MAX_NUMBER_COUNT);
    }
}
