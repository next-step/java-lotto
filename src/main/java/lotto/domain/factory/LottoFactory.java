package lotto.domain.factory;

import lotto.domain.lotto.LottoAnswer;
import lotto.domain.lotto.LottoAuto;

public class LottoFactory {

    public static LottoAuto newInstance() {
        return new LottoAuto();
    }

    public static LottoAnswer newInstance(String numbers) {
        return new LottoAnswer(numbers);
    }

}
