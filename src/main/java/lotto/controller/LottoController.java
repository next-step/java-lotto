package lotto.controller;

import lotto.domain.LottoList;
import lotto.domain.LottoMoney;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private LottoMoney lottoMoney;
    private LottoList lottoList;

    public void lottoGame() {
        lottoMoney = new LottoMoney(InputView.inputPurchaseAmount());
        ResultView.printCoinAndRemainMoney(lottoMoney);

        lottoList = new LottoList();
        lottoList.createAutoNumber(lottoMoney.getCoin());
        ResultView.printBuyLottoNumber(lottoList.getLottoList());
    }
}
