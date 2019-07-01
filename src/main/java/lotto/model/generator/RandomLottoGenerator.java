package lotto.model.generator;

import lotto.model.Lotto;
import lotto.model.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RandomLottoGenerator implements LottoGenerator {

    private long countOfLotto;
    private static final List<Number> numbers;

    static {
        numbers = IntStream.rangeClosed(Number.MIN, Number.MAX)
                .mapToObj(Number::of)
                .collect(toList());
    }

    public RandomLottoGenerator(long countOfLotto) {
        this.countOfLotto = countOfLotto;
    }

    @Override
    public List<Lotto> generator() {
        List lottos = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        Collections.shuffle(numbers);
        return numbers.stream().limit(Lotto.SIZE)
                .collect(collectingAndThen(toList(), Lotto::from));
    }
}
