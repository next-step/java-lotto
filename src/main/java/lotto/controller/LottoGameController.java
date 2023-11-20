package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.lotto.wrapper.LottoNumber;
import lotto.domain.lotto.wrapper.LottoNumbers;
import lotto.domain.lotto.wrapper.WinningNumber;
import lotto.domain.rankcount.RankCountGroup;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

import static lotto.util.LottoMachine.*;

public class LottoGameController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoGameController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void start() {
        List<LottoNumbers> lottos = purchase();
        WinningNumber winningNumber = winning();

        result(lottos, winningNumber);
    }

    private List<LottoNumbers> purchase() {
        int numOfLotto = inputView.inputPurchaseMoney();
        int countOfManual = inputView.inputCountOfManual(numOfLotto);
        List<LottoNumbers> lottos = draw(numOfLotto, countOfManual);

        resultView.printPurchaseResult(lottos, countOfManual);
        return lottos;
    }

    private List<LottoNumbers> draw(int numOfLotto, int countOfManual) {
        List<LottoNumbers> lottos = drawNumbersByAuto(numOfLotto - countOfManual);

        if (countOfManual == 0) {
            return lottos;
        }

        lottos.addAll(0, inputView.drawNumbersByManual(countOfManual));

        return lottos;
    }

    private WinningNumber winning() {
        LottoNumbers winningNumbers = inputView.inputWinningNumbers();
        LottoNumber bonusNumber = inputView.inputBonusNumber(winningNumbers);

        return new WinningNumber(winningNumbers, bonusNumber);
    }

    private void result(List<LottoNumbers> lottos, WinningNumber winningNumber) {
        LottoGame lottoGame = new LottoGame(lottos, winningNumber);
        RankCountGroup rankCountGroup = lottoGame.groupByRank();

        resultView.printLottoGameResult(rankCountGroup, lottoGame.calculateProfitRate(rankCountGroup));
    }
}
