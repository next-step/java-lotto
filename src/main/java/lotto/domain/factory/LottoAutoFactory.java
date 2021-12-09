package lotto.domain.factory;

import lotto.domain.lotto.LottoAnswer;
import lotto.domain.lotto.LottoAuto;

import java.util.List;

public class LottoAutoFactory implements LottoFactory {

    @Override
    public LottoAuto newInstance() {
        return new LottoAuto();
    }

    @Override
    public LottoAnswer newInstance(List<Integer> numbers) {
        return new LottoAnswer(numbers);
    }
}