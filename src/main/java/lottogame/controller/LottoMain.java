package lottogame.controller;

import lottogame.service.LottoGame;
import lottogame.view.InputView;
import lottogame.view.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGame lottoGame = new LottoGame();

        int buyCount = lottoGame.getBuyCount(inputView.inputBuyPrice());
        int manualBuyCount = inputView.inputManualBuyPrice();
        int autoBuyCount = buyCount - manualBuyCount;

        List<String> manualLottoList = inputView.inputManualLotto(manualBuyCount);
        outputView.resultBuyPrice(autoBuyCount, manualBuyCount);
        outputView.resultLottoList(lottoGame.purchaseManualLottoList(manualLottoList));

    }
}
