package lotto.step2.view;

import java.util.ArrayList;

public class ResultView {
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";

    public static void printLottoCount(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("금액이 부족합니다. 로또 1장의 가격은 1000원 입니다.");
        }

        System.out.printf("%d개를 구매했습니다.%n", price / 1000);
    }

    public static void printLottoTicket(ArrayList lottoTickets) {
        int lottoTicketCount = lottoTickets.size();
        for (int i=0; i<lottoTicketCount; i++) {
            System.out.println(lottoTickets.get(i));
        }
        System.out.println();
    }

    public static void printWinningStatisticsMessage() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println("---------");
    }
}
