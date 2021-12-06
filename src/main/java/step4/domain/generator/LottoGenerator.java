package step4.domain.generator;

import step4.domain.Lotto;

@FunctionalInterface
public interface LottoGenerator {
    Lotto generate();
}
