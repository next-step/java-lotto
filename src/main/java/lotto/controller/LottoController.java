package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.lotto.wrapper.LottoNumbers;
import lotto.domain.rankcount.RankCountGroup;
import lotto.util.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoController {

    private final LottoGame lottoGame;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        lottoGame = new LottoGame();
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void startGame() {
        purchase();
        winning();
    }

    private void purchase() {
        int numOfLotto = inputView.inputPurchaseMoney();

        List<LottoNumbers> lottoNumberses = drawLottoNumberses(numOfLotto);
        lottoGame.createLottos(lottoNumberses);

        resultView.printPurchaseResult(numOfLotto, lottoNumberses);
    }

    private List<LottoNumbers> drawLottoNumberses(int numOfLotto) {
        List<LottoNumbers> lottoNumberses = new ArrayList<>();

        IntStream.range(0, numOfLotto)
            .forEach(i -> {
                LottoNumbers lottoNumbers = LottoMachine.drawLottoNumbers();
                lottoNumberses.add(lottoNumbers);
            });

        return lottoNumberses;
    }

    private void winning() {
        LottoNumbers winningNumbers = inputView.inputWinningNumbers();

        RankCountGroup rankCountGroup = lottoGame.groupByRankCount(winningNumbers);
        double profitRate = lottoGame.calculateProfitRate(rankCountGroup);

        resultView.printLottoGameResult(rankCountGroup, profitRate);
    }
}
