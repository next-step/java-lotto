package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.ManualLottoCount;
import lotto.domain.Price;
import lotto.domain.WinningNumbers;
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
        final LottoTicket lottoTicket = purchaseLotto(purchaseAmount(), purchaseManualLotto());
        final LottoStatistics lottoStatistics = calculateWinningResult(lottoTicket);

        printResult(lottoStatistics);
    }

    public LottoTicket purchaseLotto(int price, LottoTicket manualLottoTicket) {
        final Price lottoPrice = Price.from(price);
        final LottoTicket lottoTicket = LottoTicketGenerator.of(lottoPrice, manualLottoTicket)
            .getLottoTicket();
        final int autoLottoCount =
            lottoTicket.getLottoTicketCount() - manualLottoTicket.getLottoTicketCount();

        OutputView.printLottoCount(
            manualLottoTicket.getLottoTicketCount(),
            autoLottoCount
        );
        ResultView.printLottoNumbers(lottoTicket.getLottoList());

        return lottoTicket;
    }

    public LottoStatistics calculateWinningResult(LottoTicket lottoTicket) {
        final WinningNumbers winningNumbers = WinningNumbers.from(
            getWinningNumber(),
            getBonusBall()
        );

        return LottoStatistics.of(winningNumbers, lottoTicket);
    }

    public void printResult(LottoStatistics lottoStatistics) {
        ResultView.printLottoStatistics(lottoStatistics);
    }

    private int purchaseAmount() {
        OutputView.printRequestLottoPrice();
        return InputView.purchasingPrice();
    }

    private LottoTicket purchaseManualLotto() {
        LottoTicket lottoTicket = LottoTicket.create();

        OutputView.printRequestManualLottoCount();
        ManualLottoCount manualLottoCount = ManualLottoCount.from(InputView.manualLottoGameCount());

        OutputView.printRequestManualLottoNumbers();
        lottoTicket.concat(
            InputView.manualLottoGameNumbers(manualLottoCount.getCount()),
            LottoTicketGenerator.LOTTO_PRICE
        );

        return lottoTicket;
    }

    private Lotto getWinningNumber() {
        OutputView.printWinningNumberBefore();
        return InputView.winningNumbers();
    }

    private LottoNumber getBonusBall() {
        OutputView.printBonusBallNumber();
        return LottoNumber.from(InputView.bonusNumber());
    }
}
