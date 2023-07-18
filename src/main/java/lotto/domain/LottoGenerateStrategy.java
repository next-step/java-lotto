package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class LottoGenerateStrategy {

    protected final List<Ball> balls;

    protected LottoGenerateStrategy(final int minNumber, final int maxNumber) {
        this.balls = IntStream.rangeClosed(minNumber, maxNumber)
                .mapToObj(Ball::new)
                .collect(Collectors.toList());
    }

    abstract Lotto generate();
}
