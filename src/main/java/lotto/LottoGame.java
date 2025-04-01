package lotto;

public class LottoGame {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        LottoTickets lottoTickets = new LottoTickets(money);
        ResultView.printLottoTickets(lottoTickets);
    }
}
