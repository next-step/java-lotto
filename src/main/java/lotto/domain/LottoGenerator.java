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

    public BoughtResult generate(final Money money) {
        return generate(money, RANDOM_GENERATE_STRATEGY);
    }

    public BoughtResult generate(final Money money, final int count) {
        return generate(money, count, RANDOM_GENERATE_STRATEGY);
    }

    public BoughtResult generate(final Money money, final LottoGenerateStrategy generateStrategy) {
        final int count = money.getValue() / Lotto.PRICE;

        return generate(money, count, generateStrategy);
    }

    public BoughtResult generate(final Money money, final int count, final LottoGenerateStrategy generateStrategy) {
        final List<Lotto> boughtLottos = new ArrayList<>();
        final Money spent = new Money(Lotto.PRICE * count);

        for (int i = 0; i < count; i++) {
            boughtLottos.add(generateStrategy.generate());
        }

        return new BoughtResult(money.subtract(spent), new BoughtLottos(boughtLottos));
    }
}
