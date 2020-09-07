package lotto;

import lotto.common.LottoNumberMatcher;
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

        LottoNumberMatcher lottoNumberMatcher = new LottoNumberMatcher(lottoPackage,
                winningTicket);
        LottoMatchResult matchResult = lottoNumberMatcher.match(money);
        OutputView.printResult(matchResult);
    }
}
