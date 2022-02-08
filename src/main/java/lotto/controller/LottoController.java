package lotto.controller;

import java.util.List;
import lotto.domain.LottoEarningRate;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ResultView;

public class LottoController {

    private int lottoPrice;
    private List<List<LottoNumber>> lottoLists;
    private Lottos lottos;
    private String winningNumber;
    private WinningNumbers winningNumbers;
    private LottoNumber bonusBall;

    public void start() {
        lottoPriceProcess();
        lottoListsProcess();
        lottoCountProcess();
        winningNumberProcess();
        statisticsProcess();
    }

    private void lottoPriceProcess() {
        OutputView.printRequestLottoPrice();
        lottoPrice = InputView.readPrice();
    }

    private void lottoListsProcess() {
        lottos = new Lottos(lottoPrice);
        lottoLists = lottos.getLottoLists();
        ResultView.printLottoNumbers(lottoLists);
    }

    private void lottoCountProcess() {
        OutputView.printLottoCount(lottos.getLottoCount());
    }

    private void winningNumberProcess() {
        OutputView.printWinningNumberBefore();
        winningNumber = InputView.readWinningNumber();
        OutputView.printBonusBallNumber();
        bonusBall = InputView.readBonusNumber();
        winningNumbers = new WinningNumbers(Util.stringToLottoNumberList(winningNumber), bonusBall);
    }

    private void statisticsProcess() {
        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers,
            lottoLists, lottoPrice);

        ResultView.printLottoStatistics(lottoStatistics.getResultStatistics(),
            LottoEarningRate.getLottoEarningRate(lottoStatistics.getResultStatistics(), lottoPrice));
    }
}
