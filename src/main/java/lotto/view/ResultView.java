package lotto.view;

import lotto.domain.*;

public class ResultView {
    private static final int MIN_COUNT_OF_WINNING_LOTTO_NUMBER = 3;
    private static final int MAX_COUNT_OF_WINNING_LOTTO_NUMBER = 6;

    private ResultView() {
        throw new IllegalArgumentException();
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getTickets()) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
    }

    public static void printLottoTicketsCount(LottoTickets lottoTickets) {
        int ticketCount = lottoTickets.getTickets().size();
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public static void printWinningStatistics(Ranks ranks, Pay pay) {
        for (int i = MIN_COUNT_OF_WINNING_LOTTO_NUMBER; i <= MAX_COUNT_OF_WINNING_LOTTO_NUMBER; i++) {

            Rank rank = Rank.of(i, false);
            System.out.println(i + "개 일치 (" + rank.getMoney() + "원) " + ranks.getCountOf(rank) + " 개");
            printBonusBall(ranks, i);
        }
        System.out.println("총 수익률은 " + ranks.returnMoneyPercentage(pay) + " 입니다.");
    }

    private static void printBonusBall(Ranks ranks, int i) {
        if (i == 5) {
            Rank rank = Rank.of(i, true);
            System.out.println(i + "개 일치, 보너스볼 일치 (" + rank.getMoney() + "원) " + ranks.getCountOf(rank) + " 개");
        }
    }
}
