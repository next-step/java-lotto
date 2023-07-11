package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private final List<Ball> balls;
    private final LottoGenerateStrategy lottoGenerateStrategy;

    public LottoGenerator() {
        this(new RandomLottoGenerateStrategy());
    }

    public LottoGenerator(final LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerateStrategy = lottoGenerateStrategy;
        this.balls = new ArrayList<>();
        for (int i = Ball.MIN_NUMBER; i <= Ball.MAX_NUMBER; i++) {
            this.balls.add(new Ball(i));
        }
    }

    public List<Lotto> generate(final Money money) {
        final int count = money.getValue() / Lotto.PRICE;
        final List<Lotto> boughtLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            boughtLottos.add(lottoGenerateStrategy.generate(balls));
        }
        return boughtLottos;
    }
}
