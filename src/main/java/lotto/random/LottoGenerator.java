package lotto.random;

import java.util.List;

@FunctionalInterface
public interface LottoGenerator {
    List<Integer> executeStrategy();
}
