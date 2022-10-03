package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumberGenerationStrategy {
    List<LottoNumber> getNumbers();
}
