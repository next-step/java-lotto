package step3.view;

import step3.domain.LottoRank;
import step3.domain.LottoTicket;
import step3.domain.ResultSheet;

import java.util.List;

public class OutputView {

    public static final int PRICE_FOR_A_LOTTO_TICKET = 1000;
    public static final String MESSAGE_FOR_EARNING_RATE = "총 수익률은 %.2f 입니다.";
    public static final String MESSAGE_FOR_LOTTO_RESULT = "%d개 일치 (%d원) - %d개";
    public static final int PRIZE_FOR_LOSER = 0;

    public static void printNumberOfTickets(int numberOfLottoTicketsToBuy) {
        System.out.println(numberOfLottoTicketsToBuy + "개를 구매했습니다.");
    }

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.stream()
                .map(LottoTicket::getLottoTicket)
                .forEach(System.out::println);
    }

    public static void printResult(ResultSheet result, int numberOfTotalTickets) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoRank rank : LottoRank.values()) {
            System.out.println(String.format(MESSAGE_FOR_LOTTO_RESULT,
                    rank.getNumberOfMatchingNumber(),
                    rank.getPrizeMoney(),
                    result.getResultMap().getOrDefault(rank, PRIZE_FOR_LOSER)));
        }

        System.out.println(String.format(MESSAGE_FOR_EARNING_RATE,
                (double) result.getTotalPrizeMoney() / result.getTotalTicketsBought()));
    }

}
