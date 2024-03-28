package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSale {
    private List<Lotto> lottos = new ArrayList<>();

    public LottoSale(String purchaseAmount, LottoStrategy lottoStrategy) {
        this.lottos = generateLottos(purchaseAmount, lottoStrategy);
    }

    private List<Lotto> generateLottos(String purchaseAmount, LottoStrategy lottoStrategy) {
        return purchaseLottos(Validator.validatePurchaseAmount(purchaseAmount), lottoStrategy);
    }

    private List<Lotto> purchaseLottos(int count, LottoStrategy lottoStrategy) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(getAutoLotto(lottoStrategy));
        }

        return lottos;
    }

    private Lotto getAutoLotto(LottoStrategy lottoStrategy) {
        List<Integer> randomLotto = new LottoGenerator().generateLottoNumbers(lottoStrategy);
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
