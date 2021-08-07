package step3.view;

import step3.domain.ResultOfLottos;
import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoRank;
import step3.domain.lotto.LottoStatistics;
import step3.domain.lotto.Profit;
import java.util.List;

public class ResultView {

    public static void printCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.numbers().toString()));
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        printLottoStatistics(lottoStatistics.resultOfLottos());
        printLottoProfit(lottoStatistics.getProfit());
    }

    private static void printLottoProfit(Profit profit) {
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

    private static void printLottoStatistics(ResultOfLottos resultOfLottos) {
        for (int rank = 3; rank < 7; rank++) {
            LottoRank lottoRank = LottoRank.find(rank);
            System.out.println(lottoRank.getNumber() + "개 일치 (" + lottoRank.getWinMoney() + " 원) - " + resultOfLottos.winCount(lottoRank));
        }
    }

}
