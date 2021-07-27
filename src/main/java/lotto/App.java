package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class App {

    public static void main(String[] args) {
        int money = buyTicket();
        Lottos buyTickets = Lottos.of(money);
        ResultView.printBuyTicket(buyTickets);

        LottoNumbers winTicket = getWinTicket();

        ResultView.printStatistics(buyTickets, winTicket);
    }

    private static LottoNumbers getWinTicket() {
        String winTicketStr = InputView.getInputWinNumbers();
        return LottoNumbers.of(winTicketStr);
    }

    private static int buyTicket() {
        int money = InputView.getInputBuyMoney();
        InputView.printBuyCount(money);

        return money;
    }
}
