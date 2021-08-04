package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoRank;
import step2.domain.LottoStatistics;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        printLottoStatistics(lottoStatistics.resultOfLottos());
        printLottoProfit(lottoStatistics.getProfit());
    }

    private static void printLottoProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

    private static void printLottoStatistics(Map<Integer, Integer> resultOfLottos) {
        resultOfLottos.forEach((rank, count) -> {
            LottoRank lottoRank = LottoRank.find(rank);
            System.out.println(lottoRank.getRank() + "개 일치 (" + lottoRank.getMoney() + " 원) - " + count);
        });
    }

}
