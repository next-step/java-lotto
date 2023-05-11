package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLottoGame {
    private final Lottos lottos;
    private final MyResult result;

    public MyLottoGame(Lottos lottos, MyPurchase myPurchase) {
        this.lottos = lottos;
        this.result = new MyResult(myPurchase);
    }

    public static MyLottoGame autoGenerate(MyPurchase myPurchase) {
        Lottos lottos = Lottos.create(myPurchase);
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
