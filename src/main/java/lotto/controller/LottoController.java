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
        Scanner scanner = new Scanner(System.in);
        BuyingAmount buyingAmount = new BuyingAmount(InputView.input(scanner));

        LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberStrategy(), buyingAmount);
        ResultView.reportBuying(lottoMachine.lottoCount(), lottoMachine.getLottoNumbers());

        WinningLotto winningLotto = new WinningLotto(InputView.winnerNumber(scanner));
        WinningResults winningResults = lottoMachine.report(winningLotto);
        ResultView.reportStats(winningResults, buyingAmount);

    }

}
