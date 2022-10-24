package step3;

import step3.controller.LottoGameController;
import step3.domain.Ticket;

public class LottoApplication {
    public static void main(String[] args) {
        LottoApplication.run();
    }

    public static void run(){
        final LottoGameController lottoGameController = new LottoGameController();
        final Ticket ticket = lottoGameController.prepareLottoTicket();
        lottoGameController.playLotto(ticket);
    }
}
