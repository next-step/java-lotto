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

    private Price lottoPrice;
    private List<Lotto> lottoTicket;
    private List<Integer> winningNumberList;
    private int bonusBall;

    private LottoMachine() {}

    public static LottoMachine getInstance() {
        if (lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }

    public void run() {
        purchaseLotto();
        calculateWinningResult();
        printResult();
    }

    public void purchaseLotto() {
        Price lottoPrice = Price.from(getLottoPrice());

        lottoTicket = convertPriceToLotto(lottoPrice);

        ResultView.printLottoNumbers(lottoTicket);
        OutputView.printLottoCount(lottoTicket.size());
    }

    public void calculateWinningResult() {
        WinningNumbers winningNumbers = WinningNumbers.from(getWinningNumber());

        winningNumberList = winningNumbers.getWinningNumbers();
        bonusBall = getBonusBall();
    }

    public void printResult() {
        statisticsProcess();
    }

    private int getLottoPrice() {
        OutputView.printRequestLottoPrice();
        return InputView.readPrice();
    }

    private List<Lotto> convertPriceToLotto(Price lottoPrice) {
        return LottoTicket.from(lottoPrice.getValue()).getLottoTicket();
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
        LottoStatistics lottoStatistics = new LottoStatistics(winningNumberList, bonusBall,
            lottoTicket, lottoPrice.getValue());

        ResultView.printLottoStatistics(lottoStatistics.getResultStatistics(),
            lottoStatistics.getLottoEarningRate());
    }
}
