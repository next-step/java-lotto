package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ResultView;

public class LottoMachine {

    private static LottoMachine lottoMachine = null;

    private int lottoPrice;
    private List<Lotto> lottoLists;
    private LottoTicket lottoTicket;
    private List<Integer> winningNumberList;
    private int bonusBall;

    private LottoMachine() {}

    public static LottoMachine getInstance() {
        if (lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }

    public void start() {
        purchaseLotto();

        lottoListsProcess();
        lottoCountProcess();
        winningNumberProcess();
        bonusBallProcess();
        statisticsProcess();
    }

    public void purchaseLotto() {
        enterLottoPrice();
    }

    private void enterLottoPrice() {
        OutputView.printRequestLottoPrice();
        lottoPrice = InputView.readPrice();
    }

    private void lottoListsProcess() {
        lottoTicket = new LottoTicket(lottoPrice);
        lottoLists = lottoTicket.getLottoLists();
        ResultView.printLottoNumbers(lottoLists);
    }

    private void lottoCountProcess() {
        OutputView.printLottoCount(lottoTicket.getLottoCount());
    }

    private void winningNumberProcess() {
        final String winningNumber;

        OutputView.printWinningNumberBefore();
        winningNumber = InputView.readWinningNumber();
        winningNumberList = Util.stringToIntegerList(winningNumber);
    }

    private void bonusBallProcess() {
        OutputView.printBonusBallNumber();
        bonusBall = InputView.readBonusNumber();
    }

    private void statisticsProcess() {
        LottoStatistics lottoStatistics = new LottoStatistics(winningNumberList, bonusBall,
            lottoLists, lottoPrice);

        ResultView.printLottoStatistics(lottoStatistics.getResultStatistics(),
            lottoStatistics.getLottoEarningRate());
    }
}
