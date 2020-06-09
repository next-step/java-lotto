package lotto.domain;

import java.util.Set;

@FunctionalInterface
public interface NumberGeneratorStrategy {
    Set<Integer> generateNumbers();
}
