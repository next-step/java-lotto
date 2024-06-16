package lotto.view;

import lotto.model.LottoGame;

public class ResultView {

    public void printLottoTicketCounts(int manualLottoTicketCount, int autoLottoTicketCount) {
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구매했습니다.\n", manualLottoTicketCount, autoLottoTicketCount);
    }

    public void printUserLottoTickets(LottoGame lottoGame) {
        lottoGame.getUserLottoTickets().getLottoTickets().stream()
                .forEach(lottoTicket -> System.out.println(lottoTicket.getLottoNumbers()));
    }
}
