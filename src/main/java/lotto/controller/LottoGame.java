package lotto.controller;

import lotto.model.LottoNumberPool;
import lotto.model.Money;
import lotto.model.MyLottos;
import lotto.view.InputView;

public class LottoGame {
    private int autoLottoCount;
    private MyLottos myLottos;

    public LottoGame(InputView inputView) {
        Money money = inputView.getMoney();
        autoLottoCount = money.findLottoCountToBuy();
    }

    public void start() {
        myLottos = LottoNumberPool.getMyLottos(autoLottoCount);
    }

    public MyLottos getMyLottos() {
        return myLottos;
    }

    public int findHowManyMyLottos() {
        return autoLottoCount;
    }
}