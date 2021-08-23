package lotto.domain;

import lotto.domain.generationStrategy.NumberGenerationStrategy;

import java.util.ArrayList;
import java.util.List;

public final class LottoMachine {

    private static final int INIT_COUNT = 0;

    public Lottos buyLotto(Money money, final List<String> manuallyLottos, final NumberGenerationStrategy numberGenerationStrategy) {
        List<Lotto> lottos = new ArrayList<>();

        money = money.spendMoneyToBuyLotto(manuallyLottos.size());

        for (String lottoNumbers : manuallyLottos) {
            lottos.add(new Lotto(lottoNumbers));
        }

        for (int i = INIT_COUNT; i < money.getNumberOfLottoAvailableForPurchases(); i++) {
            lottos.add(new Lotto(numberGenerationStrategy.generateLottoNumber()));
        }

        return new Lottos(lottos);
    }

}
