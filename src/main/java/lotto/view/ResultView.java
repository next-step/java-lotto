package lotto.view;

import lotto.domain.*;

public class ResultView {
    private static final int MIN_COUNT_OF_WINNING_LOTTO_NUMBER = 3;
    private static final int MAX_COUNT_OF_WINNING_LOTTO_NUMBER = 6;

    private ResultView() {
        throw new IllegalArgumentException();
    }

    public static void printLottoTickets(LottoTicketGroup lottoTicketGroup) {
        for (LottoTicket lottoTicket : lottoTicketGroup.getTickets()) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
    }

    public static void printLottoTicketsCount(LottoTicketGroup lottoTicketGroup) {
        int ticketCount = lottoTicketGroup.getTickets().size();
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public static void printWinningStatistics(RankGroup rankGroup, int totalTicketPrice) {
        for (int i = MIN_COUNT_OF_WINNING_LOTTO_NUMBER; i <= MAX_COUNT_OF_WINNING_LOTTO_NUMBER; i++) {
            System.out.println(i + "개 일치 (" + Rank.getMoneyByMatchCount(i) + "원) " + rankGroup.getCountOfMatchCount(i) + " 개");
        }
        System.out.println("총 수익률은 "+ rankGroup.returnMoneyPercentage(totalTicketPrice)+" 입니다.");
    }
}
