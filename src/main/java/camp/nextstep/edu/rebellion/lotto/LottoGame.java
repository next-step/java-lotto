package camp.nextstep.edu.rebellion.lotto;

import camp.nextstep.edu.rebellion.lotto.domain.ticket.Lotto;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoTicket;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoTicketGenerator;
import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningNumber;
import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningResult;
import camp.nextstep.edu.rebellion.lotto.view.InputView;
import camp.nextstep.edu.rebellion.lotto.view.ResultView;

public class LottoGame {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoTicket ticket = LottoTicketGenerator.purchaseGoodLuck(purchaseAmount);
        ResultView.printLottoTicket(ticket);



        String winnerNumbersAtLastWeek = InputView.getWinnerNumbersAtLastWeek();
        int bonusNumber = InputView.getBonusNumber();

        LottoWinningNumber winningNumber = new LottoWinningNumber(
                new Lotto(winnerNumbersAtLastWeek), bonusNumber);

        LottoWinningResult result = ticket.getWinningResult(winningNumber);
        ResultView.printWinningResult(result);
    }
}
