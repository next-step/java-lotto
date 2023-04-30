package lotto.service;

import lotto.domain.*;

public class LottoService {
    private final Purchase purchase;
    private final MyLottos myLottos;
    private final Result result;

    public LottoService(int inputMoney, MyLottos myLottos) {
        this.purchase = new Purchase(inputMoney);
        this.myLottos = myLottos;
        this.result = new Result();
    }

    public LottoService(int inputMoney) {
        this(inputMoney, new MyLottos());
    }

    public void autoGenerate() {
        myLottos.autoGenerate(purchase.count());
    }

    public MyLottos lottos() {
        return myLottos;
    }

    public void checkWin(WinLotto winLotto) {
        myLottos.checkWin(winLotto, result);
    }

    public Result result() {
        return result;
    }

    public double profit(){
        return result.profit(purchase.money());
    }
}
