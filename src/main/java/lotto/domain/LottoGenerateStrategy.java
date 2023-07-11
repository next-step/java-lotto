package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoGenerateStrategy {

    Lotto generate(final List<Ball> balls);
}
