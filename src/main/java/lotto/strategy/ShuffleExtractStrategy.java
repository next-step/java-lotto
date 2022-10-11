package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;

public class ShuffleExtractStrategy implements ExtractStrategy {

    private static final List<Integer> baseNumber = new ArrayList<>();

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            baseNumber.add(i);
        }
    }

    @Override
    public Lotto extractNumber() {
        Collections.shuffle(baseNumber);
        List<Integer> numbers = baseNumber.subList(0, WIN_COUNT);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
