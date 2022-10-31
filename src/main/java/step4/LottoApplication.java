package step4;

import step4.controller.LottoGameController;
import step4.dto.TicketDTO;

public class LottoApplication {
    public static void main(String[] args) {
        LottoApplication.run();
    }

    public static void run(){
        final LottoGameController lottoGameController = new LottoGameController();
        final TicketDTO ticketDTO = lottoGameController.prepareLottoTicket();
        lottoGameController.playLotto(ticketDTO);
    }
}
