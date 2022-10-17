package step2;

import step2.controller.LottoGameController;
import step2.domain.Ticket;

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
