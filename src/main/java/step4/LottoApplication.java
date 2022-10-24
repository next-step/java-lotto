package step4;

import step4.controller.LottoGameController;
import step4.domain.Ticket;

public class LottoApplication {
    public static void main(String[] args) {
        LottoApplication.run();
    }

    public static void run(){
        final LottoGameController lottoGameController = new LottoGameController();
        final Ticket ticket = lottoGameController.prepareLottoTicket();
        final Ticket manualLottoTicket = lottoGameController.prepareManualLottoTicket();
        lottoGameController.playLotto(ticket, manualLottoTicket);
    }
}
