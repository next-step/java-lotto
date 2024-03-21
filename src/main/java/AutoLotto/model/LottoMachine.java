package autoLotto.model;

import autoLotto.exception.PurchaseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static autoLotto.model.LottoConstants.INVALID_PURCHASE_AMOUNT;

public class LottoMachine {
    private static final Long VALID_UNIT = 1000L;

    private List<Lotto> lottos = new ArrayList<>();

    public LottoMachine(String purchaseAmount, LottoGeneratorStrategy lottoGeneratorStrategy) {
        this.lottos = generateLottos(purchaseAmount, lottoGeneratorStrategy);
    }

    private List<Lotto> generateLottos(String purchaseAmount, LottoGeneratorStrategy lottoGeneratorStrategy) {
        int chances = validatePurchaseAmount(purchaseAmount);
        return buy(chances, lottoGeneratorStrategy);
    }

    private int validatePurchaseAmount(String purchaseAmount) throws PurchaseException {
        Long purchaseAmountLong = Long.parseLong(purchaseAmount);
        purchaseAmountLong /= VALID_UNIT;

        if (purchaseAmountLong < 1L) {
            throw new PurchaseException(INVALID_PURCHASE_AMOUNT);
        }

        return purchaseAmountLong.intValue();
    }

    private List<Lotto> buy(int chances, LottoGeneratorStrategy lottoGeneratorStrategy) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < chances; i++) {
            lottos.add(getAutoLotto(lottoGeneratorStrategy));
        }

        return lottos;
    }

    private Lotto getAutoLotto(LottoGeneratorStrategy lottoGeneratorStrategy) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> randomLotto = lottoGenerator.generateLottoNumbers(lottoGeneratorStrategy);
        Collections.sort(randomLotto);

        return new Lotto(randomLotto);
    }

    public int getNumberOfLottos() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
