package lotto.domain.number.generator;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator<T> {
    List<T> getNumbers();
}
