package lotto;

import lotto.domain.LottoEarningCalculator;
import lotto.domain.LottoGame;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGameApplication {

    public static void main(String[] args) {
        int moneyForTicket = LottoInputView.getMoneyForTicket();
        List<LottoTicket> tickets = LottoGame.buy(moneyForTicket);

        LottoResultView.printTickets(tickets);

        if (tickets.isEmpty()) {
            return;
        }

        List<LottoNumber> lastWeekNumbers = LottoInputView.getLastWeekWinnerNumber().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoTicket lastWeekWinnerTicket = new LottoTicket(lastWeekNumbers);
        LottoNumber lasWeekBonusNumber = new LottoNumber(LottoInputView.getLastWeekBonusNumber());

        List<LottoPrize> prizes = LottoEarningCalculator.findPrize(tickets, lastWeekWinnerTicket, lasWeekBonusNumber);

        LottoResultView.printResult(prizes, tickets.size());
    }
}
