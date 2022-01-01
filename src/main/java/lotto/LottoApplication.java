package lotto;

import lotto.controller.LottoController;
import lotto.domain.LotteryResult;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinningLottoNumbers;
import lotto.dto.OrderRequest;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoController controller = LottoController.getInstance();
        LottoInputView inputView = LottoInputView.getInstance();
        LottoOutputView outputView = LottoOutputView.getInstance();

        Money money = Money.from(inputView.moneyInputPrompt());
        OrderRequest request = OrderRequest.from(money);
        LottoTickets tickets = controller.buy(request);

        outputView.showLottoTickets(tickets);

        WinningLottoNumbers winnings = WinningLottoNumbers.of(inputView.winningInputPrompt(), inputView.bonusInputPrompt());
        LotteryResult result = tickets.calculate(winnings);
        outputView.showLottoResult(result);
    }
}
