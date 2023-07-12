package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private final List<Ball> balls;
    private final LottoGenerateStrategy lottoGenerateStrategy;

    public LottoGenerator() {
        this(new RandomLottoGenerateStrategy());
    }

    public LottoGenerator(final LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerateStrategy = lottoGenerateStrategy;
        this.balls = IntStream.rangeClosed(Ball.MIN_NUMBER, Ball.MAX_NUMBER)
                .mapToObj(Ball::new)
                .collect(Collectors.toList());
    }

    public BoughtLottos generate(final Money money) {
        final int buyCount = money.getValue() / Lotto.PRICE;
        final List<Lotto> boughtLottos = IntStream.range(0, buyCount)
                .mapToObj(i -> lottoGenerateStrategy.generate(balls))
                .collect(Collectors.toList());
        return new BoughtLottos(boughtLottos);
    }
}
