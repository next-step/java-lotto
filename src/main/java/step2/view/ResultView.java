package step2.view;

import step2.domain.LottoTicket;
import step2.dto.Ticket;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final ResultView RESULT_VIEW = new ResultView();
    private static final String AVG_WINNING = "당첨 통계";
    private static final String DASHES = "---------";
    private static final String SAME3 = "3개 일치 (5000원)- %d개\n";
    private static final String SAME4 = "4개 일치 (50000원)- %d개\n";
    private static final String SAME5 = "5개 일치 (1500000원)- %d개\n";
    private static final String SAME6 = "6개 일치 (2000000000원)- %d개\n";
    private static final String TOTAL_RATE = "총 수익률은 %.2f 입니다.\n";
    private static final int BASE_PRICE = 1000;

    private ResultView() {}

    public static ResultView getInstance() {
        return RESULT_VIEW;
    }

    public void renderLottoStatus(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(lottoTicket -> {
            System.out.println(lottoTicket.lottoTicket());
        });
    }

    public void renderWinningResult(Ticket ticket, Map<String, Long> winningResult) {
        System.out.println(AVG_WINNING);
        System.out.println(DASHES);

        System.out.printf(SAME3, winningResult.get("3"));
        System.out.printf(SAME4, winningResult.get("4"));
        System.out.printf(SAME5, winningResult.get("5"));
        System.out.printf(SAME6, winningResult.get("6"));

        renderCalculateValue(ticket, winningResult);
    }

    private void renderCalculateValue(Ticket ticket, Map<String, Long> winningResult) {
        float calculateRate = (float)(winningResult.get("3") * 5000 +
                winningResult.get("4") * 50000 +
                winningResult.get("5") * 1500000 +
                winningResult.get("6") * 2000000000) / (float)(ticket.ticketCount() * BASE_PRICE);

        System.out.printf(TOTAL_RATE, calculateRate);
    }
}
