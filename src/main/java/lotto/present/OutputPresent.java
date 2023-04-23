package lotto.present;

import lotto.present.vo.IncomePresentVO;
import lotto.present.vo.WinnerPresentVO;

import java.util.List;

public class OutputPresent {
    private static final String STATISTICS_HEAD = "당첨 통계" + System.lineSeparator() + "---------";
    private static final String PRIZE_5TH = "3개 일치 (5000원)- %s개";
    private static final String PRISE_4TH = "4개 일치 (50000원)- %s개";
    private static final String PRIZE_3RD = "5개 일치 (1500000원)- %s개";
    private static final String PRIZE_1ST = "6개 일치 (2000000000원)- %s개";
    private static final String RETURN_RATE = "총 수익률은 %f2입니다";
    public OutputPresent() {
    }

    public void presentTickets(List<String> renderingTickets) {
        for(String renderedTicket : renderingTickets) {
            System.out.println(renderedTicket);
        }
    }

    public void presentWinners(WinnerPresentVO winnerPresentVO) {

    }

    public void presentIncome(IncomePresentVO incomePresentVO) {

    }
}
