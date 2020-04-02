package lotto2.domain;

import java.util.Set;

@FunctionalInterface
public interface GenerateStrategy {
    Set<LottoNumber> generateNumbers();
}
