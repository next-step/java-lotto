package camp.nextstep.edu.rebellion.lotto;

import camp.nextstep.edu.rebellion.lotto.domain.ticket.Lotto;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoTicket;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoTicketGenerator;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.PurchaseAmount;
import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningNumber;
import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningResult;
import camp.nextstep.edu.rebellion.lotto.view.InputView;
import camp.nextstep.edu.rebellion.lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        int money = InputView.getPurchaseAmount();
        int manualCount = InputView.getManualPurchaseCount();
        List<String> manualLottoNumbers = InputView.getManualLottoNumbers(manualCount);

        PurchaseAmount purchaseAmount = new PurchaseAmount(money, manualCount);
        LottoTicket ticket = LottoTicketGenerator.purchaseGoodLuck(purchaseAmount, manualLottoNumbers);
        ResultView.printLottoTicketTitle(purchaseAmount);
        ResultView.printLottoTicket(ticket);

        String winnerNumbersAtLastWeek = InputView.getWinnerNumbersAtLastWeek();
        int bonusNumber = InputView.getBonusNumber();
        LottoWinningNumber winningNumber = new LottoWinningNumber(winnerNumbersAtLastWeek, bonusNumber);

        LottoWinningResult result = ticket.getWinningResult(winningNumber);
        ResultView.printWinningResult(result);
        ResultView.printReturnOfInvestment(purchaseAmount, result.getTotalPrize());
    }
}
