package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class LottoMachineResultView {

    public static void showTicketNumber(LottoTickets lottoTickets) {
        for (LottoTicket ticket : lottoTickets.ticketList()) {
            LottoMachineInputView.show(ticket.showTicketNumber());
        }
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 1; i < LottoPrize.values().length; i++) {
            LottoPrize prize = LottoPrize.values()[i];
            System.out.print(String.format("%d개 일치", prize.getMatchCount()));
            System.out.print(String.format(" (%d원)", prize.getPrice()));
            System.out.println(String.format(" - %d개", lottoResult.prizeCount(prize)));
        }
        System.out.println(String.format("총 수익률은 %.2f", lottoResult.average()));
    }

}
