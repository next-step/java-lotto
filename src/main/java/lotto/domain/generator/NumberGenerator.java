package lotto.domain.generator;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {
    List<Integer> getNumbers();
}
