package lotto.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoEarningRate;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ResultView;

public class LottoController {

    private LottoPrice lottoPrice;
    private Lottos lottos;
    private String winningNumber;
    private LottoNumber bonusBall;
    private WinningLotto winningLottery;

    public void start() {
        lottoPriceProcess();
        lottoListsProcess();
        OutputView.printLottoCount(lottos.getLottoCount());
        winningNumberProcess();
        statisticsProcess();
    }

    private void lottoPriceProcess() {
        OutputView.printRequestLottoPrice();
        lottoPrice = InputView.readPrice();
    }

    private void lottoListsProcess() {
        lottos = new Lottos(lottoPrice);
        ResultView.printLottoNumbers(lottos.getLottoLists());
    }

    private void winningNumberProcess() {
        OutputView.printWinningNumberBefore();
        winningNumber = InputView.readWinningNumber();
        OutputView.printBonusBallNumber();
        bonusBall = InputView.readBonusNumber();
        winningLottery = new WinningLotto(refineToLottoList(winningNumber), bonusBall);
    }

    private void statisticsProcess() {
        LottoStatistics lottoStatistics = new LottoStatistics(winningLottery, lottos.getLottoLists());

        ResultView.printLottoStatistics(lottoStatistics.getResultStatistics(),
            LottoEarningRate.getLottoEarningRate(lottoStatistics.getResultStatistics(),
                lottoPrice));
    }

    public static Lotto refineToLottoList(String unrefinedNumber) {
        return new Lotto(Arrays.asList(unrefinedNumber.split(", ")).stream()
            .map(n -> new LottoNumber(Integer.parseInt(n)))
            .collect(Collectors.toSet()));
    }
}
