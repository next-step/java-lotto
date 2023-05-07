package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLottoGame {
    private final List<Lotto> lottos;
    private final MyResult result;

    public MyLottoGame(List<Lotto> lottos, MyPurchase myPurchase) {
        this.lottos = lottos;
        this.result = new MyResult(myPurchase);
    }

    public static MyLottoGame autoGenerate(MyPurchase myPurchase) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < myPurchase.count(); i++) {
            lottos.add(autoGenerateOne());
        }
        return new MyLottoGame(lottos, myPurchase);
    }

    private static Lotto autoGenerateOne() {
        return Lotto.autoGenerate();
    }

    public MyResult checkWin(WinLotto winLotto) {
        for (Lotto lotto : lottos) {
            result.update(lotto.checkMatchingNumbers(winLotto));
        }
        result.sumPrizeAmount();
        return result;
    }

    public int count() {
        return lottos.size();
    }

    public Lotto find(int index) {
        return lottos.get(index);
    }

    public MyResult result() {
        return result;
    }
    public double profit() {
        return result.profit();
    }

}
