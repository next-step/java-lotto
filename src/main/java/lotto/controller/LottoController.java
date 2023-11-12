package lotto.controller;

import lotto.domain.*;
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

        WinningLotto winningLotto = new WinningLotto(Lotto.from(inputView.winnerNumber()),
                new LottoNumber(inputView.inputBonusNumber()));
        WinningResults winningResults = lottoMachine.report(winningLotto);
        resultView.reportStats(winningResults, buyingAmount);
    }

}
