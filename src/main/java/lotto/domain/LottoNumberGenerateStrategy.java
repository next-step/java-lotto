package lotto.domain;

import java.util.Set;

public interface LottoNumberGenerateStrategy {
    Set<LottoNumber> generateLottoNumbers();
}
