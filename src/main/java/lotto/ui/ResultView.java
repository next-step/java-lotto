package lotto.ui;

import lotto.service.model.LottoTickets;

public class ResultView {
    private static final String ENTER = "\r\n";

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(toString(lottoTickets));
    }

    private String toString(LottoTickets lottoTickets) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s개를 구매했습니다.", lottoTickets.getLottoTicketsCount())).append(ENTER);
        lottoTickets.getLottoTickets().forEach(lottoTicket -> sb.append(lottoTicket).append(ENTER));
        return sb.toString();
    }
}
