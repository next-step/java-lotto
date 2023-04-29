package lotto.domain.util;

import lotto.domain.Lotto;

@FunctionalInterface
public interface NumberGeneratorStrategy {

    Lotto generate();

}