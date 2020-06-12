package lotto.domain;

import lotto.domain.data.Lotto;
import lotto.domain.data.ManualLotto;
import lotto.domain.data.PriceLotto;
import lotto.domain.generator.Generator;
import lotto.domain.generator.LottoGenerator;

import java.util.List;

public class LottoStore {

    private final static int LOTTO_PRICE_PER_ONE = 1000;
    private Generator generator;

    public LottoStore(Generator generator) {
        this.generator = generator;
    }

    public List<Lotto> buy(PriceLotto price, List<ManualLotto> manualLottos) {
        int autoLottoCount = getCountPossibleBuyAutoLotto(price, manualLottos.size());
        int manualLottoCount = manualLottos.size();

        price.validateEnoughPrice(LOTTO_PRICE_PER_ONE, autoLottoCount, manualLottoCount);
        List<Lotto> lottos = generator.generate(autoLottoCount, manualLottos);
        price.boughtLotto(LOTTO_PRICE_PER_ONE, autoLottoCount, manualLottoCount);

        return lottos;
    }

    private int getCountPossibleBuyAutoLotto(PriceLotto price, int manualLottoCount) {
        int autoLottoCount = ((int) Math.floor(price.getIntValue() / LOTTO_PRICE_PER_ONE)) - manualLottoCount;
        return Math.max(autoLottoCount, 0);
    }

}
