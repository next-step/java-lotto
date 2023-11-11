package lotto.controller;

import lotto.domain.BuyingAmount;
import lotto.domain.LottoMachine;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResults;
import lotto.domain.strategy.RandomLottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView();

        BuyingAmount buyingAmount = new BuyingAmount(inputView.inputAmount());

        LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberStrategy(), buyingAmount);
        resultView.reportBuying(lottoMachine.lottoCount(), lottoMachine.getLottoNumbers());

        WinningLotto winningLotto = new WinningLotto(inputView.winnerNumber(), inputView.inputBonusNumber());
        WinningResults winningResults = lottoMachine.report(winningLotto);
        resultView.reportStats(winningResults, buyingAmount);

    }

}
