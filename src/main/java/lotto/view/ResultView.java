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

    public static void printWinningStatistics(RankGroup rankGroup, int totalTicketPrice) { // 여기에 Rank 파라미터 추가
        for (int i = MIN_COUNT_OF_WINNING_LOTTO_NUMBER; i <= MAX_COUNT_OF_WINNING_LOTTO_NUMBER; i++) {

            Rank rank = Rank.of(i, false);
            System.out.println(i + "개 일치 (" + rank.getMoney() + "원) " + rankGroup.getCountOf(rank) + " 개");
            printBonusBall(rankGroup, i);
        }
        System.out.println("총 수익률은 " + rankGroup.returnMoneyPercentage(totalTicketPrice) + " 입니다.");
    }

    private static void printBonusBall(RankGroup rankGroup, int i) {
        if (i == 5) {
            Rank rank = Rank.of(i, true);
            System.out.println(i + "개 일치, 보너스볼 일치 (" + rank.getMoney() + "원) " + rankGroup.getCountOf(rank) + " 개");
        }
    }
}
