package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface CreationLottoNumber {
    List<LottoNumber> automatic();
}
