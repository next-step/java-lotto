package lotto.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lotto.domain.Lotto;

public class AutoIssueLottoStrategy implements IssueLottoStrategy {

    private final static AutoIssueLottoStrategy INSTANCE = new AutoIssueLottoStrategy();

    private final Random random = new Random();
    private final int DIGIT = 6;
    private final int BOUND = 45;

    private AutoIssueLottoStrategy() {
    }

    @Override
    public List<Lotto> issue(final int number) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            result.add(new Lotto(generateLottoNumbers()));
        }
        return result;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < DIGIT; i++) {
            result.add(random.nextInt(BOUND) + 1);
        }
        return result;
    }

    public static AutoIssueLottoStrategy getInstance() {
        return INSTANCE;
    }
}
