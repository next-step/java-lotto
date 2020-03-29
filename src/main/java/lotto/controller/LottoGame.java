package lotto.controller;

import lotto.model.LottoNumberPool;
import lotto.model.Money;
import lotto.model.MyLottos;
import lotto.view.InputView;
import lotto.view.StringConverter;

public class LottoGame {
    private int autoLottoCount;
    private MyLottos myLottos;

    public LottoGame(InputView inputView) {
        Money money = StringConverter.convertStringToMoney(inputView.getInput());
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