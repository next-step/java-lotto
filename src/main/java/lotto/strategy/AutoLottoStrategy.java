package lotto.strategy;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Collections.shuffle;

public class AutoLottoStrategy implements LottoRuleStrategy {
    private static final AutoLottoStrategy AUTO_LOTTO_STRATEGY = new AutoLottoStrategy();

    private AutoLottoStrategy() {}

    public static AutoLottoStrategy getInstance() {
        return AUTO_LOTTO_STRATEGY;
    }

    @Override
    public Lotto ticketing(final Collection<LottoNumber> lottoNumbers) {
        ArrayList<LottoNumber> lottoNumberArrayList = new ArrayList<>(lottoNumbers);
        shuffle(lottoNumberArrayList);
        return Lotto.from(lottoNumberArrayList.subList(0, 6));
    }
}
