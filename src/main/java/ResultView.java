import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ResultView {

    public static void printBuyLotto(int number) {
        System.out.println(number + "개를 구입하였습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printStatics(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        Arrays.stream(Rank.values())
                .filter(rank -> rank.getCountOfMatch() != 0)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> System.out.println(getStaticText(rank, lottoResult.rankCount(rank))));

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
