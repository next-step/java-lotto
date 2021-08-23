package lotto.domain;

import lotto.domain.exception.MoneyLowException;
import lotto.domain.generationStrategy.NumberGenerationStrategy;

import java.util.ArrayList;
import java.util.List;

public final class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int INIT_COUNT = 0;

    public Lottos buyLotto(final int amount, final NumberGenerationStrategy numberGenerationStrategy) {
        validateAmount(amount);
        return new Lottos(createLotto(amount, numberGenerationStrategy));
    }

    private void validateAmount(final int amount) {
        if (amount < LOTTO_PRICE) {
            throw new MoneyLowException();
        }
    }

    private List<Lotto> createLotto(final int amount, final NumberGenerationStrategy numberGenerationStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = amount / LOTTO_PRICE;
        for (int i = INIT_COUNT; i < lottoCount; i++) {
            lottos.add(new Lotto(numberGenerationStrategy.generateLottoNumber()));
        }
        return lottos;
    }

    public Lottos buyManuallyLottos(List<String> manuallyLottos) {
        // money = money.spendMoneyToBuyLotto(manuallyLottos.size());

        return null;
    }

}
