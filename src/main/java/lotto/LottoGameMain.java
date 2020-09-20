package lotto;

import lotto.domain.LottoMatchResult;
import lotto.domain.LottoPack;
import lotto.domain.LottoTicketMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameMain {

    public static void main(String[] args) {
        int money = InputView.inputMoney();

        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();

        LottoPack lottoPack = lottoTicketMachine.issueTickets(money);
        OutputView.printBuyingTickets(lottoPack);

        String winningNumbers = InputView.inputLastWeekWinningNumbers();
        String bonusNumber = InputView.inputBonusNumber();
        LottoMatchResult matchResult = lottoPack.matchResult(winningNumbers, bonusNumber);

        OutputView.printResult(matchResult);
    }
}
