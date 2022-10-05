package lotto.domain;

import lotto.domain.vo.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface NumberGenerationStrategy {
    List<LottoNumber> getNumbers();
}
