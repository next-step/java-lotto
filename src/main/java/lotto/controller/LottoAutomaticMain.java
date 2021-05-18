package lotto.controller;

import lotto.domain.LottoAuto;
import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoAutomaticMain {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();

    static LottoGame lottoGame = new LottoGame();
    public static void main(String[] args) {

        int buyCount = lottoGame.getBuyCount(inputView.inputBuyPrice());
        resultView.resultBuyPrice(buyCount);

        Lottos lottos = lottoGame.getLottos(buyCount);

        for(LottoAuto lotto : lottos){
            System.out.println(lotto.getlotto());
        }
    }
}
