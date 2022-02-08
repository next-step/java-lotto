package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.Price;
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

        winningNumberProcess();
        bonusBallProcess();
        statisticsProcess();
    }

    public void purchaseLotto() {
        Price lottoPrice = Price.from(getLottoPrice());

        lottoTicket = convertPriceToLotto(lottoPrice);

        ResultView.printLottoNumbers(lottoTicket);
        OutputView.printLottoCount(lottoTicket.size());
    }

    private int getLottoPrice() {
        OutputView.printRequestLottoPrice();
        return InputView.readPrice();
    }

    private List<Lotto> convertPriceToLotto(Price lottoPrice) {
        return LottoTicket.from(lottoPrice.getValue()).getLottoTicket();
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
            lottoTicket, lottoPrice.getValue());

        ResultView.printLottoStatistics(lottoStatistics.getResultStatistics(),
            lottoStatistics.getLottoEarningRate());
    }
}
