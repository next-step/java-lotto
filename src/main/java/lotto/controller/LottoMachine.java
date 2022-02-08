package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.Price;
import lotto.domain.WinningNumbers;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ResultView;

public class LottoMachine {

    private static LottoMachine lottoMachine = null;

    private LottoStatistics lottoStatistics;

    private LottoMachine() {}

    public static LottoMachine getInstance() {
        if (lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }

    public void run() {
        final LottoTicket lottoTicket = purchaseLotto(getLottoPrice());
        calculateWinningResult(lottoTicket);
//        printResult();
    }

    public LottoTicket purchaseLotto(int price) {
        final Price lottoPrice = Price.from(price);
        final LottoTicket lottoTicket = convertPriceToLotto(lottoPrice);

        ResultView.printLottoNumbers(lottoTicket.getLottoTicket());
        OutputView.printLottoCount(lottoTicket.getLottoTicket().size());

        return lottoTicket;
    }

    public void calculateWinningResult(LottoTicket lottoTicket) {
        final List<Integer> winningNumberList = WinningNumbers.from(getWinningNumber()).getWinningNumbers();
        final int bonusBall = getBonusBall();

        lottoStatistics = new LottoStatistics(winningNumberList, bonusBall,
            lottoTicket.getLottoTicket(), lottoTicket.getLottoTicketPrice());
    }

    public void printResult() {
        statisticsProcess();
    }

    private int getLottoPrice() {
        OutputView.printRequestLottoPrice();
        return InputView.readPrice();
    }

    private LottoTicket convertPriceToLotto(Price lottoPrice) {
        return LottoTicket.from(lottoPrice.getValue());
    }

    private List<Integer> getWinningNumber() {
        OutputView.printWinningNumberBefore();
        return Util.stringToIntegerList(InputView.readWinningNumber());
    }

    private int getBonusBall() {
        OutputView.printBonusBallNumber();
        return InputView.readBonusNumber();
    }

    private void statisticsProcess() {
        ResultView.printLottoStatistics(lottoStatistics.getResultStatistics(),
            lottoStatistics.getLottoEarningRate());
    }
}
