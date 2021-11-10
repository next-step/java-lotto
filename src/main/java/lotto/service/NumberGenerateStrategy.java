package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

@FunctionalInterface
public interface NumberGenerateStrategy {

    List<Integer> generate();
}
