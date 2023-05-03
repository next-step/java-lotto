package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {
    private final List<MyLotto> myLottos;
    private final Purchase purchase;
    private final Result result;

    public MyLottos(List<MyLotto> myLottos, Purchase purchase) {
        this.myLottos = myLottos;
        this.purchase = purchase;
        this.result = new Result(purchase);
    }

    public static MyLottos autoGenerate(Purchase purchase) {
        List<MyLotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchase.count(); i++) {
            lottos.add(autoGenerateOne());
        }
        return new MyLottos(lottos, purchase);
    }

    private static MyLotto autoGenerateOne() {
        return MyLotto.auto();
    }

    public void checkWin(WinLotto winLotto) {
        for (MyLotto myLotto : myLottos) {
            myLotto.checkMatchingNumbers(winLotto);
            result.update(myLotto);
        }
        result.sumPrizeAmount();
    }

    public int count() {
        return myLottos.size();
    }

    public MyLotto find(int index) {
        return myLottos.get(index);
    }

    public Result result() {
        return result;
    }
    public double profit() {
        return result.profit();
    }

}
