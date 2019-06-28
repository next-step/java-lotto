package view;

import domain.LottoSet;
import domain.LottoResult;
import domain.Rank;
import domain.RankCount;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ResultView {

    public static void printBuyLottoPaper(List<LottoSet> lottoPaper) {
        System.out.println(lottoPaper.size() + "개를 구매했습니다.");

        lottoPaper.forEach(System.out::println);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        RankCount rankCount = lottoResult.getLottoRankCount();
        rankCount.getRankCount().keySet().stream()
                .filter(rank -> rank.getCountOfMatch() != 0)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> System.out.println(getStaticText(rank, rankCount.getNumberOfRankCount(rank))));

        System.out.println("총 수익률은 " + lottoResult.getProfit() + "입니다.");
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
}
