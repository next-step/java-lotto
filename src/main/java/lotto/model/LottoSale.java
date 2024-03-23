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
        int purchaseChance = validatePurchaseAmount(purchaseAmount);
        return purchaseLottos(purchaseChance, lottoStrategy);
    }

    private int validatePurchaseAmount(String purchaseAmount)  {
        int purchaseCount = Integer.parseInt(purchaseAmount) / 1000;

        if (purchaseCount < 1) {
            throw new IllegalArgumentException("로또는 장당 1000원입니다.");
        }

        return purchaseCount;
    }

    private List<Lotto> purchaseLottos(int chances, LottoStrategy lottoStrategy) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < chances; i++) {
            lottos.add(getAutoLotto(lottoStrategy));
        }

        return lottos;
    }

    private Lotto getAutoLotto(LottoStrategy lottoStrategy) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> randomLotto = lottoGenerator.generateLottoNumbers(lottoStrategy);
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
