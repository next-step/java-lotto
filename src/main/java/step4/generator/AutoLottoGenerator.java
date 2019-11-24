package step4.generator;

import step4.model.Lotto;
import step4.model.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.lottoCount(); i++) {
            lottos.add(makeLotto());
        }
        return lottos;
    }

    public Lotto makeLotto() {
        List<Integer> numbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, 6);
        Collections.sort(numbers);
        return Lotto.of(numbers);
    }
}
