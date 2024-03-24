package autoLotto.model;

import autoLotto.exception.PurchaseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static autoLotto.model.LottoConstants.INVALID_PURCHASE_AMOUNT;

public class LottoMachine {
    private static final Long VALID_UNIT = 1000L;

    private List<Lotto> lottos;

    public LottoMachine(Long purchaseAmount, LottoGeneratorStrategy lottoGeneratorStrategy) {
        this.lottos = generateLottos(purchaseAmount, lottoGeneratorStrategy);
    }

    private List<Lotto> generateLottos(Long purchaseAmount, LottoGeneratorStrategy lottoGeneratorStrategy) {
        int chances = validatePurchaseAmount(purchaseAmount);
        return buy(chances, lottoGeneratorStrategy);
    }

    private int validatePurchaseAmount(Long purchaseAmount) throws PurchaseException {
        purchaseAmount /= VALID_UNIT;

        if (purchaseAmount < 1L) {
            throw new PurchaseException(INVALID_PURCHASE_AMOUNT);
        }

        return purchaseAmount.intValue();
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
        Set<LottoNumber> randomLotto = lottoGenerator.generateLottoNumbers(lottoGeneratorStrategy);

        return new Lotto(randomLotto);
    }

    public int getNumberOfLottos() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
