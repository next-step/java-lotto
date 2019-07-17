package lotto.strategy;

import java.util.List;

@FunctionalInterface
public interface LottoNumberStrategy {
    List<Integer> generate();
}
