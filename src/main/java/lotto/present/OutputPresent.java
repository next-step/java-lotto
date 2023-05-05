package lotto.present;

import lotto.domain.Ticket;
import lotto.domain.Tickets;
import lotto.present.dto.IncomePresentDTO;
import lotto.present.dto.WinnerPresentDTO;

public class OutputPresent {
    private static final String STATISTICS_HEAD = "당첨 통계" + System.lineSeparator() + "---------";
    private static final String PRIZE_5TH = "3개 일치 (5,000원)- %s개";
    private static final String PRIZE_4TH = "4개 일치 (50,000원)- %s개";
    private static final String PRIZE_3RD = "5개 일치 (1,500,000원)- %s개";
    private static final String PRIZE_2ND = "5개 일치, 보너스 볼 일치(30,000,000원) - %s개";
    private static final String PRIZE_1ST = "6개 일치 (2,000,000,000원)- %s개";
    private static final String RETURN_RATE = "총 수익률은 %f2입니다";
    private static final String CONFIRM_PURCHASE = "수동으로 %s장, 자동으로 %s장 을 구매했습니다%s";

    public void presentWinners(WinnerPresentDTO winnerPresentDTO) {
        System.out.println(STATISTICS_HEAD);
        System.out.printf(PRIZE_5TH + System.lineSeparator(), winnerPresentDTO.getCountFifth());
        System.out.printf(PRIZE_4TH + System.lineSeparator(), winnerPresentDTO.getCountFourth());
        System.out.printf(PRIZE_3RD + System.lineSeparator(), winnerPresentDTO.getCountThird());
        System.out.printf(PRIZE_2ND + System.lineSeparator(), winnerPresentDTO.getCountSecond());
        System.out.printf(PRIZE_1ST + System.lineSeparator(), winnerPresentDTO.getCountFirst());
    }

    public void presentIncome(IncomePresentDTO incomePresentDTO) {
        System.out.printf(RETURN_RATE, incomePresentDTO.getProfitRatio());
        System.out.print(incomePresentDTO.getBreakEvenMessage());
    }

    public void presentTickets(Tickets manualTickets, Tickets autoTickets) {
        System.out.printf(CONFIRM_PURCHASE, manualTickets.count(), autoTickets.count(), System.lineSeparator());
        for (Ticket ticket : manualTickets.allTickets()) {
            System.out.println(ticket.toString());
        }
        for (Ticket ticket : autoTickets.allTickets()) {
            System.out.println(ticket.toString());
        }
    }
}
