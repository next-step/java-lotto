package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class App {

    public static void main(String[] args) {
        Lottos buyTickets = Lottos.of(buyTicket());
        ResultView.printBuyTicket(buyTickets);

        LottoNumbers winTicket = getWinTicket();

        ResultView.printStatistics(buyTickets, winTicket);
    }

    private static LottoNumbers getWinTicket() {
        return LottoNumbers.of(InputView.getInputWinNumbers());
    }

    private static int buyTicket() {
        int money = InputView.getInputBuyMoney();
        InputView.printBuyCount(money);

        return money;
    }
}
