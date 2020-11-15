package lotto.domain.lotto;

import lotto.domain.lotto.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface CreateLottoNumbersStrategy {
    List<LottoNumber> create();
}
