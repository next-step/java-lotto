package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.WinningLottoNumber;
import lotto.domain.WinningResults;
import lotto.domain.strategy.RandomLottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = InputView.input(scanner);

        LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberStrategy(), amount);
        ResultView.reportBuying(lottoMachine.lottoCount(), lottoMachine.getLottoNumbers());

        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(InputView.winnerNumber(scanner));
        WinningResults winningResults = lottoMachine.report(winningLottoNumber);
        ResultView.reportStats(winningResults, amount);

    }

}
