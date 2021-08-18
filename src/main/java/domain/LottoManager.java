package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private Lottos lottos;

    public LottoManager() {
        this(0);
    }

    public LottoManager(int purchaseAmount) {
        makeLottos(getPurchaseLottoCount(purchaseAmount));
    }

    private void makeLottos(int purchaseLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseLottoCount; i++) {
            lottoList.add(new Lotto(new AutoNumberStrategy()));
        }
        this.lottos = new Lottos(lottoList);
    }

    public Lottos getLottos() {
        return this.lottos;
    }

    public int getPurchaseLottoCount(int purchaseAmount) {
        return Lotto.calcPurchaseLottoCount(purchaseAmount);
    }

    public Lotto makeLotto(PickNumberStrategy pickNumberStrategy) {
        return new Lotto(pickNumberStrategy);
    }

    public BonusBall makeBonusBall(int bonusBall) {
        return new BonusBall(bonusBall);
    }

    public void findWinningLottoResult(WinningLotto winningLotto) {
        lottos.makeWinningLottoResult(winningLotto);
    }

    public double getLottoYield(int purchaseAmount) {
        return lottos.calcLottoYield(Lotto.calcPurchaseLottoCount(purchaseAmount) * LottoPrice.LOTTO_PRICE);
    }

    public WinningStatistics getWinningResult() {
        return lottos.getWinningStatistics();
    }
}
