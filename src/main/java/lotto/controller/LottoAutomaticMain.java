package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoList;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoAutomaticMain {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();

    static LottoGame lottoGame = new LottoGame();

    public static void main(String[] args) {

        int buyCount = lottoGame.getBuyCount(inputView.inputBuyPrice());
        resultView.resultBuyPrice(buyCount);

        LottoList lottos = lottoGame.getLottoList(buyCount);
        resultView.resultLottoList(lottos);

        lottoGame.getWinningNumbers(inputView.inputWinningLottoNumbers(), inputView.inputBonusNumber());

        Map<Rank, Long> winning =  lottoGame.getWinning();
        resultView.resultStatistics(winning);
lottoGame.getStatistics(winning);
    }
}
