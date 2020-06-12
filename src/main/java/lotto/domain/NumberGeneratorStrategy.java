package lotto.domain;

import java.util.Set;

@FunctionalInterface
public interface NumberGeneratorStrategy {
    Set<LottoNumber> generateNumbers();
}
