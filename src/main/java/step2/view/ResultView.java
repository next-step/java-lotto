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
        Ranks ranks = winner.getRanks();

        for (RankEnum rank : RankEnum.values()) {
           printRank(rank, ranks);
        }

        System.out.println("총 수익률은 " + winner.toStringProfit() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private static void printRank(RankEnum rank, Ranks ranks) {
        StringBuilder bounusMatchBuilder = new StringBuilder();
        StringBuilder rewardBuilder = new StringBuilder();

        if (rank.getReward() == NO_MATCH_REWARD) {
            return;
        }

        if (rank.getReward() == FIVE_BONUS_REWARD) {
            bounusMatchBuilder.append("5개 일치, 보너스 볼 일치 (");
            bounusMatchBuilder.append(rank.getReward());
            bounusMatchBuilder.append("원)- ");
            bounusMatchBuilder.append(ranks.getOrDefault(rank, 0));
            bounusMatchBuilder.append("개");

            System.out.println(bounusMatchBuilder.toString());
            return;
        }

        rewardBuilder.append(rank.getMatchCount());
        rewardBuilder.append("개 일치 (");
        rewardBuilder.append(rank.getReward());
        rewardBuilder.append("원)- ");
        rewardBuilder.append(ranks.getOrDefault(rank, 0));
        rewardBuilder.append("개");
        System.out.println(rewardBuilder);
    }

    private static void newLine() {
        System.out.print(System.lineSeparator());
    }
}
