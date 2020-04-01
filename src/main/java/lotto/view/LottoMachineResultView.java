package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class LottoMachineResultView {
    private static final int START_LOTTO_PRIZE_INDEX = 0;
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계\n-------";
    private static final String RESULT_FORMAT = "%s - %d개";

    public static void showTicketNumber(LottoTickets lottoTickets) {
        for (LottoTicket ticket : lottoTickets.ticketList()) {
            LottoMachineInputView.show(ticket.showTicketNumber());
        }
    }
    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        for (int i = START_LOTTO_PRIZE_INDEX; i < LottoPrize.PRIZES.size(); i++) {
            LottoPrize prize = LottoPrize.PRIZES.get(i);
            System.out.println(String.format(RESULT_FORMAT,
                    prize.getMessage(),
                    lottoResult.prizeCount(prize)));
        }
        System.out.println(String.format("총 수익률은 %.2f", lottoResult.average()));
    }

}
