package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final LottoGenerateStrategy RANDOM_GENERATE_STRATEGY = new RandomLottoGenerateStrategy();

    private final List<Ball> balls;

    private static class LottoGeneratorHandler {

        private static final LottoGenerator INSTANCE = new LottoGenerator();

    }

    private LottoGenerator() {
        this.balls = new ArrayList<>();

        for (int i = Ball.MIN_NUMBER; i <= Ball.MAX_NUMBER; i++) {
            this.balls.add(new Ball(i));
        }
    }

    public static LottoGenerator getInstance() {
        return LottoGeneratorHandler.INSTANCE;
    }

    public BoughtLottos generate(final Money money) {
        return generate(money, RANDOM_GENERATE_STRATEGY);
    }

    public BoughtLottos generate(final Money money, final LottoGenerateStrategy generateStrategy) {
        final int count = money.getValue() / Lotto.PRICE;
        final List<Lotto> boughtLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            boughtLottos.add(generateStrategy.generate(balls));
        }

        return new BoughtLottos(boughtLottos);
    }
}
