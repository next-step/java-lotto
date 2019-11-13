package step2.view;

import step2.domain.*;

import java.util.List;

public class ResultView {
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
        StringBuilder bonusMatchBuilder = new StringBuilder();
        StringBuilder rewardBuilder = new StringBuilder();

        if (rank.checkZeroReward()) {
            return;
        }

        if (rank == RankEnum.FIVE_BONUS) {
            bonusMatchBuilder.append("5개 일치, 보너스 볼 일치 (");
            bonusMatchBuilder.append(rank.getReward());
            bonusMatchBuilder.append("원)- ");
            bonusMatchBuilder.append(ranks.getOrDefault(rank));
            bonusMatchBuilder.append("개");

            System.out.println(bonusMatchBuilder.toString());
            return;
        }

        rewardBuilder.append(rank.getMatchCount());
        rewardBuilder.append("개 일치 (");
        rewardBuilder.append(rank.getReward());
        rewardBuilder.append("원)- ");
        rewardBuilder.append(ranks.getOrDefault(rank));
        rewardBuilder.append("개");
        System.out.println(rewardBuilder);
    }

    private static void newLine() {
        System.out.print(System.lineSeparator());
    }
}
