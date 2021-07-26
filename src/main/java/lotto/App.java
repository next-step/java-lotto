package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class App {

    public static void main(String[] args) {
        int money = buyTicket();
        List<LottoNumbers> buyTickets = generateTicket(money);

        LottoNumbers winTicket = getWinTicket();

        LottoStatistics statistics = LottoStatistics.of(winTicket, buyTickets);
        ResultView.printStatistics(statistics);
    }

    private static LottoNumbers getWinTicket() {
        String winTicketStr = InputView.getInputWinNumbers();
        return LottoNumbers.of(winTicketStr);
    }

    private static List<LottoNumbers> generateTicket(int money) {
        LottoTickets buy = LottoTickets.of(money);
        List<LottoNumbers> lottoTickets = buy.getLottoTickets();
        ResultView.printBuyTicket(lottoTickets);

        return lottoTickets;
    }

    private static int buyTicket() {
        int money = InputView.getInputBuyMoney();
        InputView.printBuyCount(money);

        return money;
    }
}
