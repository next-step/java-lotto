package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoNumbersGenerator {
    List<Integer> generate();
}
