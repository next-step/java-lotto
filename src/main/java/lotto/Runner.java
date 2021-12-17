package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoTickets;

public class Runner {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        LottoTickets lottoTickets = lottoController.buyAndPrintLotto();
        lottoController.winningInformationOf(lottoTickets);
    }

}
