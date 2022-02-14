package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ResultView;

public class LottoController {
    private LottoPrice lottoPrice;
    private Lottos lottos;
    private String winningNumber;
    private LottoNumber bonusBall;
    private WinningLotto winningLotto;
    private List<Rank> winningRanks;

    public void start() {
        lottoPriceProcess();
        lottoListsProcess();
        OutputView.printLottoCount(lottos.getLottoLists().size());
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
        winningLotto = new WinningLotto(refineToLottoList(winningNumber), bonusBall, lottos);
        winningRanks = winningLotto.matchRank();
    }

    private void statisticsProcess() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        String lottoEaringRate = lottoStatistics.getLottoEarningRate(winningRanks, lottoPrice);
        ResultView.printLottoStatistics(winningRanks, lottoEaringRate);
    }

    public static Lotto refineToLottoList(String unrefinedNumber) {
        return new Lotto(Arrays.asList(unrefinedNumber.split(", ")).stream()
            .map(n -> new LottoNumber(Integer.parseInt(n)))
            .collect(Collectors.toSet()));
    }
}
