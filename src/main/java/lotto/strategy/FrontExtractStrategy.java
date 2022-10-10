package lotto.strategy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class FrontExtractStrategy implements ExtractStrategy {

    private static final List<Integer> baseNumber = new ArrayList<>();

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            baseNumber.add(i);
        }
    }

    @Override
    public Lotto extractNumber() {
        List<Integer> numbers = baseNumber.subList(0, WIN_COUNT);
        return new Lotto(numbers);
    }
}
