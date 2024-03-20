package autoLotto.model;

import autoLotto.exception.PurchaseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachine {
    private List<Lotto> lottos = new ArrayList<>();

    private static final Long VALID_UNIT = 1000L;
    private static final String INVALID_PURCHASE_AMOUNT = "로또 1장은 1,000원이며, 지불하신 금액으로는 로또 구매가 불가능합니다.";

    public LottoMachine(String purchaseAmount, LottoGeneratorStrategy lottoGeneratorStrategy) {
        int chances = validatePurchaseAmount(purchaseAmount);
        this.lottos = buy(chances, lottoGeneratorStrategy);
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
        int[] randomLotto = lottoGenerator.generateLottoNumbers(lottoGeneratorStrategy);
        Arrays.sort(randomLotto);

        return new Lotto(randomLotto);
    }

    public Lotto retrieveLotto(int index) {
        return lottos.get(index);
    }

    public int getNumberOfLottos() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
