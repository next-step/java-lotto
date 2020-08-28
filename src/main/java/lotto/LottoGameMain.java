package lotto;

import java.util.List;
import lotto.common.LottoNumberMatcher;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoSeller;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameMain {

    public static void main(String[] args) {
        int money = InputView.inputMoney();

        LottoSeller lottoSeller = new LottoSeller(money);
        OutputView.printTicketCount(lottoSeller);

        List<LottoTicket> lottoTickets = lottoSeller.sellTickets();
        OutputView.printBuyingTickets(lottoTickets);

        String winningNumbers = InputView.inputLastWeekWinningNumbers();
        LottoTicket winningTicket = lottoSeller.getWinningTicket(winningNumbers);

        LottoNumberMatcher lottoNumberMatcher = new LottoNumberMatcher(lottoTickets,
              winningTicket);
        LottoMatchResult matchResult = lottoNumberMatcher.match(money);
        OutputView.printResult(matchResult);
    }
}
