package lotto;

import lotto.common.LottoTicketMachine;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoPackage;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameMain {

    public static void main(String[] args) {
        int money = InputView.inputMoney();

        LottoPackage lottoPackage = LottoTicketMachine.issueTickets(money);
        OutputView.printBuyingTickets(lottoPackage);

        String winningNumbers = InputView.inputLastWeekWinningNumbers();
        LottoTicket winningTicket = LottoTicketMachine.issueTicket(winningNumbers);

        LottoMatchResult lottoMatchResult = lottoPackage.matchResult(winningTicket, money);
        OutputView.printResult(lottoMatchResult);
    }
}
