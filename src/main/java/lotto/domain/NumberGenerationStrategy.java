package lotto.domain;

import java.util.List;

import lotto.domain.vo.LottoNumber;

@FunctionalInterface
public interface NumberGenerationStrategy {
    List<LottoNumber> getNumbers();
}
