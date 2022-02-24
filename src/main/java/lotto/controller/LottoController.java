package lotto.controller;

import java.util.List;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.machine.LottoSupplier;
import lotto.domain.ticket.Money;
import lotto.domain.ticket.PurchaseTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        OutputView outputView = new OutputView();

        Money money = getMoney();
        PurchaseTicket ticket = new PurchaseTicket(money, getManualLottoNumbers());
        Lottos lottos = ticket.purchase();

        outputView.printPurchaseAmount(ticket);
        outputView.printPurchaseTicket(lottos);

        WinningNumber winningNumber = InputView.makeWinningNumber();
        WinningResult winningResult = new WinningResult(lottos, winningNumber);
        winningResult.calculateYield(ticket.getBuyCash());

        outputView.printWinningResult(winningResult);
    }

    private Money getMoney() {
        try {
            return new Money(InputView.getMoney());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getMoney();
        }
    }

    private List<Lotto> getManualLottoNumbers() {
        int manualTicketCount = getManualCount();

        List<List<LottoNumber>> manualLottoNumbers = InputView.getManualLottoNumbers(manualTicketCount);

        return LottoSupplier.makeManualLotto(manualLottoNumbers);
    }

    private int getManualCount() {
        return InputView.getManualTicketCount();
    }
}
