package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoGenerateStrategy {

    Lotto generate(List<Ball> balls);
}
