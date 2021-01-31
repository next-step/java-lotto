package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoTicket;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        LottoController lottoController = applicationContext.getLottoController();
        List<LottoTicket> lottoTickets = lottoController.purchaseLottoTickets();
        lottoController.getWinner(lottoTickets);
    }
}
