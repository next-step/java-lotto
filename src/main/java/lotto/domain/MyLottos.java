package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {
    private final List<MyLotto> myLottos;
    private final MyResult result;

    public MyLottos(List<MyLotto> myLottos, MyPurchase myPurchase) {
        this.myLottos = myLottos;
        this.result = new MyResult(myPurchase);
    }

    public static MyLottos autoGenerate(MyPurchase myPurchase) {
        List<MyLotto> lottos = new ArrayList<>();
        for (int i = 0; i < myPurchase.count(); i++) {
            lottos.add(autoGenerateOne());
        }
        return new MyLottos(lottos, myPurchase);
    }

    private static MyLotto autoGenerateOne() {
        return MyLotto.auto();
    }

    public void checkWin(WinLotto winLotto) {
        for (MyLotto myLotto : myLottos) {
            result.update(myLotto.checkMatchingNumbers(winLotto));
        }
        result.sumPrizeAmount();
    }

    public int count() {
        return myLottos.size();
    }

    public MyLotto find(int index) {
        return myLottos.get(index);
    }

    public MyResult result() {
        return result;
    }
    public double profit() {
        return result.profit();
    }

}
