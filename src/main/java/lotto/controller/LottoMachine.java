package lotto.controller;

import java.util.List;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.Price;
import lotto.domain.WinningNumbers;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ResultView;

public class LottoMachine {

    private static LottoMachine lottoMachine = null;

    private LottoMachine() {
    }

    public static LottoMachine getInstance() {
        if (lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }

    public void run() {
        final LottoTicket lottoTicket = purchaseLotto(purchaseAmount());
        final LottoStatistics lottoStatistics = calculateWinningResult(lottoTicket);

        printResult(lottoStatistics);
    }

    public LottoTicket purchaseLotto(int price) {
        final Price lottoPrice = Price.from(price);
        final LottoTicket lottoTicket = LottoTicketGenerator.from(lottoPrice).getLottoTicket();

        ResultView.printLottoNumbers(lottoTicket.getLottoList());
        OutputView.printLottoCount(lottoTicket.getLottoList().size());

        return lottoTicket;
    }

    public LottoStatistics calculateWinningResult(LottoTicket lottoTicket) {
        final List<Integer> winningNumberList = WinningNumbers.from(getWinningNumber())
            .getWinningNumbers();
        final int bonusBall = getBonusBall();

        return LottoStatistics.of(winningNumberList, bonusBall, lottoTicket);
    }

    public void printResult(LottoStatistics lottoStatistics) {
        ResultView.printLottoStatistics(lottoStatistics);
    }

    private int purchaseAmount() {
        OutputView.printRequestLottoPrice();
        return InputView.readPrice();
    }

    private List<Integer> getWinningNumber() {
        OutputView.printWinningNumberBefore();
        return Util.stringToIntegerList(InputView.readWinningNumber());
    }

    private int getBonusBall() {
        OutputView.printBonusBallNumber();
        return InputView.readBonusNumber();
    }
}
