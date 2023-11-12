package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER_COUNT = 0;
    private static final int MAX_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public RandomLottoNumberStrategy() {
        List<Integer> list = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            list.add(i);
        }
        this.numbers = list;
    }

    @Override
    public List<LottoNumber> create() {
        List<Integer> list = new ArrayList<>(createRandomNumbers());
        Collections.sort(list);

        return list.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

    }

    protected List<Integer> createRandomNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(MIN_NUMBER_COUNT, MAX_NUMBER_COUNT);
    }
}
