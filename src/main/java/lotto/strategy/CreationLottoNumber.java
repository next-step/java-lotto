package lotto.strategy;

import lotto.domain.Lotto;

@FunctionalInterface
public interface CreationLottoNumber {
    Lotto lottoNumbers(String lottoNumbers);
}
