package view;

import domain.LottoPaper;
import domain.Rank;
import domain.RankCount;

import java.util.Comparator;

public final class ResultView {

    public static void printLottoResult(RankCount rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        rankCount.getRankCount().keySet().stream()
                .filter(rank -> rank.getCountOfMatch() != 0)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> System.out.println(getStaticText(rank, rankCount.getNumberOfRankCount(rank))));

        System.out.println("총 수익률은 " + rankCount.calculateProfit() + "입니다.");
    }

    private static String getStaticText(Rank rank, int count) {
        String bonusMatchText = "";
        if (Rank.SECOND == rank) {
            bonusMatchText = ", 보너스 볼 일치";
        }
        return new StringBuilder().append(rank.getCountOfMatch())
                .append("개 일치")
                .append(bonusMatchText)
                .append(" (" + rank.getWinningMoney())
                .append("원) - ")
                .append(count)
                .append("개").toString();
    }

    public static void printBuyLottoPaper(LottoPaper lottoPaper) {
        System.out.println("수동으로 " + lottoPaper.getManualLottoSetsSize() + "장, 자동으로" + lottoPaper.getAutoLottoSetsSize() + "개를 구매했습니다.");

        lottoPaper.getLottoSets().forEach(System.out::println);
    }
}