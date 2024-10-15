package lotto.application.strategy;

import lotto.domain.LottoNumbers;

import java.util.List;

public interface LottoNumberGenerator {
    List<LottoNumbers> generate(int generateCount);

}
