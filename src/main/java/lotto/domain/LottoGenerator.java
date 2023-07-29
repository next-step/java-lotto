package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final LottoGenerateStrategy RANDOM_GENERATE_STRATEGY = new RandomLottoGenerateStrategy();
    private static final String NOT_ENOUGHT_MONEY_EXCEPTION_MONEY = "금액이 부족해 구매할 수 없습니다.";

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

    public BoughtResult generate(final Money money, final Count count) {
        validate(money, count);

        return generate(money, count, RANDOM_GENERATE_STRATEGY);
    }

    public BoughtResult generate(final Money money, final LottoGenerateStrategy generateStrategy) {
        final int count = money.getValue() / Lotto.PRICE;

        return generate(money, new Count(count), generateStrategy);
    }

    public BoughtResult generate(final Money money, final Count count, final LottoGenerateStrategy generateStrategy) {
        final List<Lotto> boughtLottos = new ArrayList<>();
        final Money spent = new Money(Lotto.PRICE * count.getValue());

        for (int i = 0; i < count.getValue(); i++) {
            boughtLottos.add(generateStrategy.generate());
        }

        return new BoughtResult(money.subtract(spent), new BoughtLottos(boughtLottos));
    }

    public BoughtResult generateManually(final Money money, final List<Lotto> lottos) {
        validate(money, new Count(lottos.size()));

        final BoughtLottos boughtLottos = new BoughtLottos(lottos);
        final Money spent = new Money(Lotto.PRICE * lottos.size());

        return new BoughtResult(money.subtract(spent), boughtLottos);
    }

    private void validate(final Money money, final Count count) {
        if (money.getValue() < Lotto.PRICE * count.getValue()) {
            throw new IllegalArgumentException(NOT_ENOUGHT_MONEY_EXCEPTION_MONEY);
        }
    }
}
