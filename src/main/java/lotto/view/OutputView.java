package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Tickets;

public class OutputView {

        private OutputView() {
        }

        public static void printPurchaseCount(int count) {
                System.out.println(count + "개를 구매했습니다.");
        }

        public static void printGeneratedTickets(Tickets lottoTickets) {
                lottoTickets.tickets().forEach(lottoTicket -> System.out.println(lottoTicket.numbers().toString()));
                System.out.println();
        }

        public static void printResult(Lotto lotto) {
                printResultOfWinningTitle();
                printResultOfWinning(lotto.tickets().matchRankCountMap());
                printRateOfBenefit(lotto.tickets().rateOfBenefit());
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
                        System.out.println(rank.description() + "- " + matchRankCountMap.get(rank) + "개");
                }
        }

        private static void printRateOfBenefit(double rateOfBenefit) {
                System.out.println("총 수익률은 " + rateOfBenefit + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
}
