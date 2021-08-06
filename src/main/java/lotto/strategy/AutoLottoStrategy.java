package lotto.strategy;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

public class AutoLottoStrategy extends LottoRuleStrategy {
    private static final AutoLottoStrategy AUTO_LOTTO_STRATEGY = new AutoLottoStrategy();

    private AutoLottoStrategy() {}

    public static AutoLottoStrategy getInstance() {
        return AUTO_LOTTO_STRATEGY;
    }

    @Override
    public Lotto ticketing() {
        List<LottoNumber> list = new ArrayList<>(LOTTO_NUMBERS_RANGE);
        shuffle(list);
        return Lotto.from(list.subList(0, 6));
    }
}
