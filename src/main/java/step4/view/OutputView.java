package step4.view;

import step4.domain.LottoRank;
import step4.domain.LottoTicket;
import step4.domain.LottoTickets;
import step4.domain.ResultSheet;

public class OutputView {
    private static final String MESSAGE_FOR_TOTAL_NUMBER_OF_LOTTO_BOUGHT = "수동으로 %d개, 자동으로 %d개를 구매했습니다.";
    private static final String MESSAGE_FOR_ALL_PLACE = "%d개 일치 (%d원) - %d개";
    private static final String MESSAGE_FOR_SECOND_PLACE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String MESSAGE_FOR_EARNING_RATE = "총 수익률은 %.2f 입니다.";
    private static final int PRIZE_FOR_LOSER = 0;
    private static final int SECOND_PLACE_PRIZE = 30_000_000;

    public static void printNumberOfTickets(int numberOfManualTickets, int numberOfAutoTickets) {
        System.out.println(String.format(MESSAGE_FOR_TOTAL_NUMBER_OF_LOTTO_BOUGHT,
                numberOfManualTickets,
                numberOfAutoTickets));
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().stream()
                .map(LottoTicket::getLottoTicket)
                .forEach(System.out::println);
    }

    public static void printResult(ResultSheet result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoRank rank : LottoRank.values()) {
            String messageFormat =
                    (rank.getPrizeMoney() == SECOND_PLACE_PRIZE) ? MESSAGE_FOR_SECOND_PLACE : MESSAGE_FOR_ALL_PLACE;
            System.out.println(String.format(messageFormat,
                    rank.getNumberOfMatchingNumber(),
                    rank.getPrizeMoney(),
                    result.getResultMap().getOrDefault(rank, PRIZE_FOR_LOSER)));
        }
        System.out.println(String.format(MESSAGE_FOR_EARNING_RATE, result.getEarningRate()));
    }

}
