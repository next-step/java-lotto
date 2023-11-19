package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.lotto.wrapper.LottoNumbers;
import lotto.domain.lotto.wrapper.WinningNumber;
import lotto.domain.rankcount.RankCountGroup;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameController {

    private final PurchaseController purchaseController;
    private final WinningController winningController;

    public LottoGameController() {
        this.purchaseController = new PurchaseController(new InputView(), new ResultView());
        this.winningController = new WinningController(new InputView(), new ResultView());
    }

    public void start() {
        List<LottoNumbers> lottos = purchaseController.purchase();
        WinningNumber winningNumber = winningController.winning();

        LottoGame lottoGame = new LottoGame(lottos, winningNumber);
        RankCountGroup rankCountGroup = lottoGame.groupByRank();

        winningController.result(rankCountGroup, lottoGame.calculateProfitRate(rankCountGroup));
    }


}
