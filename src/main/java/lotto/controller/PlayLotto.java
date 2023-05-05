package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {
    public static void main(String[] args) {
        int money = InputView.inputMoney();

        int lotOfLotto = LottoStore.buyLotto(money);
        List<Lotto> lottoList;
        lottoList = LottoStore.pickUpLottos(lotOfLotto);
    }

}
