package step2.view;

import step2.domain.ResultOfLottos;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.LottoStatistics;
import step2.domain.lotto.Profit;
import java.util.List;

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

    private static void printLottoProfit(Profit profit) {
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

    private static void printLottoStatistics(ResultOfLottos resultOfLottos) {
        for (int rank = 3; rank < 7; rank++) {
            LottoNumber lottoNumber = LottoNumber.find(rank);
            System.out.println(lottoNumber.getNumber() + "개 일치 (" + lottoNumber.getWinMoney() + " 원) - " + resultOfLottos.winCount(lottoNumber));
        }
    }

}
