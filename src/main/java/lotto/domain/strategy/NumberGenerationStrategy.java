package lotto.domain.strategy;

import java.util.List;

@FunctionalInterface
public interface NumberGenerationStrategy {
    List<Integer> generate();
}
