package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoTickets;
import lotto.view.TicketPrintView;
import lotto.view.TicketPurchaseView;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = LottoController.getInstance();
        // 구매 가격을 입력한다.
        Integer money = TicketPurchaseView.buyTicket();
        // 구매 가격을 출력한다.
        LottoTickets lottoTickets = lottoController.buyTickets(money);
        // 구매된 티켓 번호를 출력한다.
        TicketPrintView.ticketPrint(lottoTickets);
        // 당첨번호를 입력한다.
        // 당첨 통계를 보여준다.
    }

}
