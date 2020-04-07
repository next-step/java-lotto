package lotto.domain.machine;

import lotto.domain.lotto.LottoNumbers;

import java.util.List;

public interface LottoNumberStrategy {
    List<LottoNumbers> get();
}
