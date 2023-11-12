package lotto.controller;

import lotto.ManualCount;
import lotto.domain.*;
import lotto.domain.strategy.ManualLottoNumberStrategy;
import lotto.domain.strategy.RandomLottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView();

        BuyingAmount buyingAmount = new BuyingAmount(inputView.inputAmount());
        ManualCount manualCount = new ManualCount(inputView.inputManualCount());
        List<String> lottoNumbers = inputView.inputManualNumbers(manualCount);

        List<Lotto> collect = lottoNumbers.stream()
                .map(ManualLottoNumberStrategy::new)
                .map(ManualLottoNumberStrategy::create)
                .map(Lotto::new)
                .collect(Collectors.toList());

        LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberStrategy(), buyingAmount, collect);
        resultView.reportBuying(lottoMachine.lottoCount(),
                lottoMachine.manualLottoCount(),
                lottoMachine.getManualLottoNumbers(),
                lottoMachine.getLottoNumbers());

        WinningLotto winningLotto = new WinningLotto(Lotto.from(inputView.winnerNumber()),
                new LottoNumber(inputView.inputBonusNumber()));
        WinningResults winningResults = lottoMachine.report(winningLotto);
        resultView.reportStats(winningResults, buyingAmount);
    }

}
