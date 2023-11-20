package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.List;

public interface NumberGeneration {
    List<LottoNumber> generate();
}
