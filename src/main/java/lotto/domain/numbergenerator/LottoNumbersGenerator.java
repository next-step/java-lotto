package lotto.domain.numbergenerator;

import lotto.domain.LottoNumber;

import java.util.List;

public interface LottoNumbersGenerator {
    List<LottoNumber> generate();
}
