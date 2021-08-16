package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private Lottos lottos;

    private Lotto winningLotto;

    private BonusBall bonusBall;

    private WinningStatistics winningStatistics;

    public LottoManager() {
        this(0);
    }

    public LottoManager(int purchaseAmount) {
        this.winningStatistics = new WinningStatistics();
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

    public Lotto makeWinningLotto(PickNumberStrategy pickNumberStrategy) {
        winningLotto = new Lotto(pickNumberStrategy);
        return winningLotto;
    }

    public BonusBall makeBonusBall(int bonusBall) {
        this.bonusBall = new BonusBall(bonusBall);
        return this.bonusBall;
    }


    public void findWinningLottoResult() {
        lottos.makeWinningLottoResult(winningLotto, bonusBall);
    }

    public double getLottoYield(int purchaseAmount) {
        return winningStatistics.calcLottoYield(Lotto.calcPurchaseLottoCount(purchaseAmount) * LottoPrice.LOTTO_PRICE);
    }
}
