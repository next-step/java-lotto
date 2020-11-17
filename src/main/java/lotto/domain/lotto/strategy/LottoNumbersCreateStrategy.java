package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;

@FunctionalInterface
public interface LottoNumbersCreateStrategy {
    LottoNumbers create(LottoNumber bonusNumber);
}
