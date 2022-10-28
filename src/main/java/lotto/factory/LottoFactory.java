package lotto.factory;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LottoFactory {

    private LottoFactory() {
    }

    public static Lotto make(final LottoNumberStrategy lottoNumberStrategy) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();
        while (lottoNumberSet.size() < 6) {
            lottoNumberSet.add(lottoNumberStrategy.generate());
        }

        return new Lotto(new ArrayList<>(lottoNumberSet));
    }
}
