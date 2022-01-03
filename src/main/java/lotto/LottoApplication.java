package lotto;

import lotto.controller.LottoController;
import lotto.domain.*;
import lotto.dto.OrderRequest;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoController controller = LottoController.getInstance();
        LottoInputView inputView = LottoInputView.getInstance();
        LottoOutputView outputView = LottoOutputView.getInstance();

        Money money = Money.from(inputView.moneyInputPrompt());

        int count = inputView.manualInputPrompt();
        List<LottoNumbers> manualTickets = inputView.manualLottoNumbersInputPrompt(count);

        OrderRequest request = OrderRequest.from(money, manualTickets);
        LottoTickets tickets = controller.buy(request);

        outputView.showLottoTickets(count, tickets);

        WinningLottoNumbers winnings = WinningLottoNumbers.of(inputView.winningInputPrompt(), inputView.bonusInputPrompt());
        LotteryResult result = tickets.calculate(winnings);
        outputView.showLottoResult(result);
    }
}
