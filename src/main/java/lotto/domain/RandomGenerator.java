package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface RandomGenerator {
    List<Integer> randomNumbers();
}
