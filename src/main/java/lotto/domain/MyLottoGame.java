package lotto.domain;

import java.util.List;

public class MyLottoGame {
    private final Lottos lottos;
    private final MyResult result;

    public MyLottoGame(Lottos lottos, MyPurchase myPurchase) {
        this.lottos = lottos;
        this.result = new MyResult(myPurchase);
    }

    public static MyLottoGame generate(MyPurchase myPurchase, List<LottoNumbers> manualLottos) {
        Lottos lottos = Lottos.create(myPurchase, manualLottos);
        return new MyLottoGame(lottos, myPurchase);
    }

    public MyResult checkWin(WinLotto winLotto) {
        lottos.checkWin(result, winLotto);
        return result;
    }

    public MyResult result() {
        return result;
    }

    public int countRank(Rank rank) {
        return result().countRank(rank);
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }
}
