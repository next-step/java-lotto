package lotto.domain.factory;

import lotto.domain.lotto.LottoAnswer;
import lotto.domain.lotto.LottoAuto;

public class LottoAutoFactory implements LottoFactory {

    @Override
    public LottoAuto newInstance() {
        return new LottoAuto();
    }

    @Override
    public LottoAnswer newInstance(String numbers) {
        return new LottoAnswer(numbers);
    }
}