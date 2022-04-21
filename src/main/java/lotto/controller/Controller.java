package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Store;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        int price = InputView.inputPrice();

        Store store = new Store();
        store.pay(price);
        List<Lotto> lottos = store.receive();

        ResultView.printCountOfLottos(store.countOfLottos(price));
        ResultView.printResultOfPurchase(lottos);
    }
}
