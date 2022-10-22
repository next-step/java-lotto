package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class AutoIssueLottoStrategy implements IssueLottoStrategy {

    private static final AutoIssueLottoStrategy INSTANCE = new AutoIssueLottoStrategy();
    private static final int DIGIT = 6;
    private static final int BOUND = 45;

    private final List<Integer> numbers = new ArrayList<>();

    private AutoIssueLottoStrategy() {
        for (int i = 1; i <= BOUND; i++) {
            numbers.add(i);
        }
    }

    @Override
    public List<Lotto> issue(final int quantity) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Collections.shuffle(numbers);
            result.add(new Lotto(numbers.subList(0, DIGIT)));
        }
        return result;
    }

    public static AutoIssueLottoStrategy getInstance() {
        return INSTANCE;
    }
}
