package lotto.domain.factory;

import lotto.domain.lotto.LottoAnswer;
import lotto.domain.lotto.LottoAuto;

import java.util.List;

public interface LottoFactory {

    LottoAuto newInstance();

    LottoAnswer newInstance(List<Integer> numbers);

}
