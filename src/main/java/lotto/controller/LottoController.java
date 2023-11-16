package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.lotto.wrapper.LottoNumbers;
import lotto.domain.rankcount.RankCountGroup;
import lotto.util.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {

        inputView = new InputView();
        resultView = new ResultView();
    }

    public void startGame() {
        LottoGame lottoGame = new LottoGame();

        purchase(lottoGame);
        winning(lottoGame);
    }

    private void purchase(LottoGame lottoGame) {
        int numOfLotto = inputView.inputPurchaseMoney();

        List<LottoNumbers> lottoNumberses = drawLottoNumberses(numOfLotto);
        lottoGame.createLottos(lottoNumberses);

        resultView.printPurchaseResult(numOfLotto, lottoNumberses);
    }

    private List<LottoNumbers> drawLottoNumberses(int numOfLotto) {
        return IntStream.range(0, numOfLotto)
            .mapToObj(i -> LottoMachine.drawLottoNumbers())
            .collect(Collectors.toUnmodifiableList());
    }

    private void winning(LottoGame lottoGame) {
        LottoNumbers winningNumbers = inputView.inputWinningNumbers();

        RankCountGroup rankCountGroup = lottoGame.groupByRankCount(winningNumbers);
        double profitRate = lottoGame.calculateProfitRate(rankCountGroup);

        resultView.printLottoGameResult(rankCountGroup, profitRate);
    }
}
