package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface LottoNumbersCreateStrategy {
    List<LottoNumber> create(LottoNumber bonusNumber);
}
