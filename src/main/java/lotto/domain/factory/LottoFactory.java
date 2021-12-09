package lotto.domain.factory;

import lotto.domain.lotto.LottoAnswer;
import lotto.domain.lotto.LottoAuto;

public interface LottoFactory {

    LottoAuto newInstance();

    LottoAnswer newInstance(String numbers);

}
