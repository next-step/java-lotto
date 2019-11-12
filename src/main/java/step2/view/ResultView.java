package step2.view;

import step2.domain.*;

import java.util.List;

public class ResultView {
    private static final int NO_MATCH_REWARD = 0;
    private static final int FIVE_BONUS_REWARD = 3_000_000;

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.size() + "를 구매했습니다.");

        List<LottoTicket> lottos = lottoTickets.getLottoTickets();

        for (LottoTicket lottoTicket : lottos) {
            printLottoTicket(lottoTicket);
        }
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.toString());
    }

    public static void printWinnerStatistics(Winner winner) {
        newLine();
        System.out.println("당첨통계");
        System.out.println("---------");

        printStatistics(winner);
    }

    public static void printStatistics(Winner winner) {
        Ranks countOfRanks = winner.getCountOfRanks();

        for (RankEnum rank : RankEnum.values()) {
           printRank(rank, countOfRanks);
        }

        System.out.println("총 수익률은 " + winner.toStringProfit() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private static void printRank(RankEnum rank, Ranks countOfRanks) {
        if (rank.getReward() == NO_MATCH_REWARD) {
            return;
        }

        if (rank.getReward() == FIVE_BONUS_REWARD) {
            System.out.println("5개 일치, 보너스 볼 일치 (" + rank.getReward() + "원)- " + countOfRanks.getOrDefault(rank, 0) + "개");
            return;
        }

        System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getReward() + "원)- " + countOfRanks.getOrDefault(rank, 0) + "개");
    }

    private static void newLine() {
        System.out.print(System.lineSeparator());
    }
}
