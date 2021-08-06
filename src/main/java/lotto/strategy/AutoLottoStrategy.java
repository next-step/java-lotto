package lotto.strategy;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.ArrayList;

import static java.util.Collections.shuffle;

public class AutoLottoStrategy extends LottoRuleStrategy {
    private static final AutoLottoStrategy AUTO_LOTTO_STRATEGY = new AutoLottoStrategy();

    private AutoLottoStrategy() {}

    public static AutoLottoStrategy getInstance() {
        return AUTO_LOTTO_STRATEGY;
    }

    @Override
    public Lotto ticketing() {
        ArrayList<LottoNumber> lottoNumberArrayList = new ArrayList<>(LOTTO_NUMBERS_RANGE);
        shuffle(lottoNumberArrayList);
        return Lotto.from(lottoNumberArrayList.subList(0, 6));
    }
}
