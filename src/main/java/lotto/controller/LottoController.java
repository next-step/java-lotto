package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
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

    private int boughtLottoPrice;
    private List<Lotto> lottoList;
    private Lottos userLottos;
    private String winningNumber;
    private LottoNumber bonusBall;
    private WinningNumbers winningNumbers;

    public void start() {
        lottoPriceProcess();
        lottoListsProcess();
        OutputView.printLottoCount(userLottos.getLottoCount());
        winningNumberProcess();
        statisticsProcess();
    }

    private void lottoPriceProcess() {
        OutputView.printRequestLottoPrice();
        boughtLottoPrice = InputView.readPrice();
    }

    private void lottoListsProcess() {
        userLottos = new Lottos(boughtLottoPrice);
        ResultView.printLottoNumbers(userLottos.getLottoLists());
    }

    private void winningNumberProcess() {
        OutputView.printWinningNumberBefore();
        winningNumber = InputView.readWinningNumber();
        OutputView.printBonusBallNumber();
        bonusBall = InputView.readBonusNumber();
        winningNumbers = new WinningNumbers(Util.stringToLottoNumberList(winningNumber), bonusBall);
    }

    private void statisticsProcess() {
        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, lottoList);

        ResultView.printLottoStatistics(lottoStatistics.getResultStatistics(),
            LottoEarningRate.getLottoEarningRate(lottoStatistics.getResultStatistics(),
                boughtLottoPrice));
    }
}
