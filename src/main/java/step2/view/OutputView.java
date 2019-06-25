package step2.view;

import step2.domain.LottoRank;
import step2.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static final int PRICE_FOR_A_LOTTO_TICKET = 1000;
    public static final String MESSAGE_FOR_EARNING_RATE = "총 수익률은 %.2f 입니다.";
    public static final String MESSAGE_FOR_LOTTO_RESULT = "%d개 일치 (%d원) - %d개";

    public static void printNumberOfLottoTickets(int numberOfLottoTicketsToBuy) {
        System.out.println(numberOfLottoTicketsToBuy + "개를 구매했습니다.");
    }

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.stream()
                .map(LottoTicket::getLottoTicket)
                .forEach(System.out::println);
    }

    public static void printResult(Map<LottoRank, List<LottoTicket>> lottoResult, int numberOfTotalTickets) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        long totalPrizeMoney = 0;
        for (LottoRank rank : LottoRank.values()) {
            System.out.println(String.format(MESSAGE_FOR_LOTTO_RESULT,
                    rank.getNumberOfMatchedToLuckyNumber(),
                    rank.getPrizeMoney(),
                    lottoResult.getOrDefault(rank, new ArrayList<>()).size()));

            totalPrizeMoney += rank.getPrizeMoney() * lottoResult.getOrDefault(rank, new ArrayList<>()).size();
        }

        System.out.println(String.format(MESSAGE_FOR_EARNING_RATE,
                (double) totalPrizeMoney / (numberOfTotalTickets * PRICE_FOR_A_LOTTO_TICKET)));
    }

}
