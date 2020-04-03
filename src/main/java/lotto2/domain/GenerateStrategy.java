package lotto2.domain;

import java.util.List;

@FunctionalInterface
public interface GenerateStrategy {
    List<LottoNumber> generateNumbers();
}
