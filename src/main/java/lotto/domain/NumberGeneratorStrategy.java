package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumberGeneratorStrategy {
    List<Integer> generateNumbers();
}
