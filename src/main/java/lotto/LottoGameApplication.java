package lotto;

import java.util.List;

public class LottoGameApplication {


    public static void main(String[] args) {
        int moneyForTicket = LottoInputView.getMoneyForTicket();

        List<LottoTicket> tickets = LottoGame.buy(moneyForTicket);

        LottoResultView.print(tickets);
    }
}
