package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.Ticket;
import lotto.domain.Tickets;

public class OutputView {

        private OutputView() {
        }

        public static void printPurchaseCount(int count) {
                System.out.println(count + "개를 구매했습니다.");
        }

        public static void printGeneratedTickets(List<Ticket> lottoTickets) {
                lottoTickets.forEach(lottoTicket -> System.out.println(Arrays.toString(lottoTicket.numbers())));
                System.out.println();
        }

        public static void printResult(Tickets tickets) {
                printResultOfWinningTitle();
                printResultOfWinning(tickets.matchRankCountMap());
                printRateOfBenefit(tickets.rateOfBenefit());
        }

        private static void printResultOfWinningTitle() {
                System.out.println();
                System.out.println("당첨 통계");
                System.out.println("---------");
        }

        private static void printResultOfWinning(Map<Rank, Integer> matchRankCountMap) {
                for (Rank rank : Rank.values()) {
                        printExceptForMissRank(rank, matchRankCountMap);
                }
        }

        private static void printExceptForMissRank(Rank rank, Map<Rank, Integer> matchRankCountMap) {
                if (rank != Rank.MISS) {
                        System.out.println(
                            rank.matchCount() + "개 일치 (" + rank.winningMoney() + "원)" + " - " + matchRankCountMap.get(
                                rank) + "개");
                }
        }

        private static void printRateOfBenefit(double rateOfBenefit) {
                System.out.println("총 수익률은 " + rateOfBenefit + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
}
