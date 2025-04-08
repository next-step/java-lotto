package lotto.domain.generator;

import lotto.domain.model.LottoNumber;

import java.util.List;

public interface LottoNumberGenerator {
    List<LottoNumber> generate();
}
