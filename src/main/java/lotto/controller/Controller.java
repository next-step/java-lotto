package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Store;
import lotto.ui.InputView;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        int price = InputView.inputPrice();
        Store store = new Store();
        store.pay(price);
        List<Lotto> lottos = store.receive();

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
