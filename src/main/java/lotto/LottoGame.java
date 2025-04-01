package lotto;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        LottoTickets lottoTickets = new LottoTickets(money);
        ResultView.printLottoTickets(lottoTickets);
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        LottoTicket winningTicket = new LottoTicket(winningNumbers);
    }
}
