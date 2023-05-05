package lotto.controller;

import lotto.domain.LottoStore;
import lotto.view.InputView;

public class PlayLotto {
    public static void main(String[] args) {
        int money = InputView.inputMoney();

        int lotOfLotto = LottoStore.buyLotto(money);

    }

}
