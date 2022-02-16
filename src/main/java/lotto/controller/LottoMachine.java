package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.ManualLottoCount;
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
        final WinningNumbers winningNumbers = WinningNumbers.from(Lotto.from(getWinningNumber()),
            getBonusBall());

        return LottoStatistics.of(winningNumbers, lottoTicket);
    }

    public void printResult(LottoStatistics lottoStatistics) {
        ResultView.printLottoStatistics(lottoStatistics);
    }

    private int purchaseAmount() {
        OutputView.printRequestLottoPrice();
        return InputView.readInt();
    }

    private LottoTicket purchaseManualLotto() {
        LottoTicket lottoTicket = LottoTicket.create();

        OutputView.printRequestManualLottoCount();
        ManualLottoCount manualLottoCount = ManualLottoCount.from(InputView.readInt());

        OutputView.printRequestManualLottoNumbers();
        for (int i = 0; i < manualLottoCount.getCount(); i++) {
            Lotto manualLotto = Lotto.from(Util.stringToIntegerList(InputView.readWinningNumber()));
            lottoTicket.append(manualLotto, LottoTicketGenerator.LOTTO_PRICE);
        }

        return lottoTicket;
    }

    private List<LottoNumber> getWinningNumber() {
        OutputView.printWinningNumberBefore();
        return Util.stringToIntegerList(InputView.readWinningNumber());
    }

    private LottoNumber getBonusBall() {
        OutputView.printBonusBallNumber();
        return LottoNumber.from(InputView.readBonusNumber());
    }
}
