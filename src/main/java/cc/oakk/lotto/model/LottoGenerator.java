package cc.oakk.lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static final int LOTTO_PRICE = 1000;
    private List<Integer> numbers;

    public LottoGenerator() {
        this.numbers = Lotto.RANGE.createRangeList();
    }

    public Lotto generate() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, Lotto.NUMBER_COUNT));
    }
}
