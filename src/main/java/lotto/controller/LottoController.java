package lotto.controller;

import lotto.domain.LottoEarningRate;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ResultView;

public class LottoController {

    private LottoPrice lottoPrice;
    private Lottos userLottos;
    private String winningNumber;
    private LottoNumber bonusBall;
    private WinningLotto winningLottery;

    public void start() {
        lottoPriceProcess();
        lottoListsProcess();
        OutputView.printLottoCount(userLottos.getLottoCount());
        winningNumberProcess();
        statisticsProcess();
    }

    private void lottoPriceProcess() {
        OutputView.printRequestLottoPrice();
        lottoPrice = InputView.readPrice();
    }

    private void lottoListsProcess() {
        userLottos = new Lottos(lottoPrice);
        ResultView.printLottoNumbers(userLottos.getLottoLists());
    }

    private void winningNumberProcess() {
        OutputView.printWinningNumberBefore();
        winningNumber = InputView.readWinningNumber();
        OutputView.printBonusBallNumber();
        bonusBall = InputView.readBonusNumber();
        winningLottery = new WinningLotto(Util.stringToLottoNumberList(winningNumber), bonusBall);
    }

    private void statisticsProcess() {
        LottoStatistics lottoStatistics = new LottoStatistics(winningLottery, userLottos.getLottoLists());

        ResultView.printLottoStatistics(lottoStatistics.getResultStatistics(),
            LottoEarningRate.getLottoEarningRate(lottoStatistics.getResultStatistics(),
                lottoPrice));
    }
}
