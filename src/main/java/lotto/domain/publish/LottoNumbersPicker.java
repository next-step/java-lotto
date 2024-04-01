package lotto.domain.publish;

import java.util.Set;

import lotto.domain.LottoNumber;

public interface LottoNumbersPicker {

    Set<LottoNumber> pickMain();

    LottoNumber pickBonus();
}
