package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.List;

public interface LottoNumbersStrategy {

    List<LottoNumber> generate();
}
