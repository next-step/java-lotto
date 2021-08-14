package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private static final int LOTTO_PRICE = 1000;

    private Lottos lottos;

    private int purchaseLottoCount;

    private Lotto winningLotto;

    private WinningStatistics winningStatistics;

    public LottoManager(int purchaseAmount) {
        this.winningStatistics = new WinningStatistics();
        makePurchaseLottoCount(purchaseAmount);
        makeLottos(this.purchaseLottoCount);
    }

    private void makePurchaseLottoCount(int purchaseAmount) {
        this.purchaseLottoCount = purchaseAmount / LOTTO_PRICE;
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

    public int getPurchaseLottoCount() {
        return purchaseLottoCount;
    }

    public Lotto makeWinningLotto() {
        winningLotto = new Lotto(new ManualNumberStrategy());
        return winningLotto;
    }

    public WinningStatistics findWinningLottoResult() {
        return lottos.findWinningLottoResult(winningLotto, winningStatistics);
    }

    public double getLottoYield() {
        return winningStatistics.calcLottoYield(purchaseLottoCount * LOTTO_PRICE);
    }
}
