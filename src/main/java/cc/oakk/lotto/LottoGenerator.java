package cc.oakk.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private List<Integer> numbers;

    public LottoGenerator() {
        this.numbers = IntStream.range(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public Lotto generate() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, Lotto.NUMBER_COUNT));
    }
}
