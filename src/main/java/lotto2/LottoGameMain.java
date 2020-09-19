package lotto2;

import lotto2.domain.LottoMatchResult;
import lotto2.domain.LottoPack;
import lotto2.domain.LottoTicketMachine;
import lotto2.view.InputView;
import lotto2.view.OutputView;

public class LottoGameMain {

    public static void main(String[] args) {
        int money = InputView.inputMoney();

        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();

        LottoPack lottoPack = lottoTicketMachine.issueTickets(money);
        OutputView.printBuyingTickets(lottoPack);

        String winningNumbers = InputView.inputLastWeekWinningNumbers();
        LottoMatchResult matchResult = lottoPack.matchResult(winningNumbers);

        OutputView.printResult(matchResult);
    }
}
