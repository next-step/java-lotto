package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.MatchResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameMain {

    public static void main(String[] args) {
        int money = InputView.money();
        LottoTickets lottoTickets = new LottoTickets(money);
        OutputView.printTickets(lottoTickets);

        String winningNumbers = InputView.lastWinningNumbers();
        LottoTicket winningTicket = new LottoTicket(winningNumbers);

        MatchResult matchResult = lottoTickets.match(winningTicket);
        OutputView.printResults(matchResult);
    }
}
