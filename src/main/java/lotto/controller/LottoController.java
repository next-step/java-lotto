package lotto.controller;

import lotto.domain.LottoList;
import lotto.domain.LottoMoney;
import lotto.view.InputView;

public class LottoController {

    private LottoMoney lottoMoney;
    private LottoList lottoList;

    public void lottoGame() {
        lottoMoney = new LottoMoney(InputView.inputPurchaseAmount());
        lottoList = new LottoList();
        lottoList.createAutoNumber(lottoMoney.getCoin());

    }
}
