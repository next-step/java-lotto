package view;

import domain.Lotto;
import domain.LottoStatistics;
import domain.LottoUnitWinnings;
import domain.LottoWinningsCalculator;

import java.util.List;

public class ResultView {

    public static void printLottos(List<Lotto> lottos) {
        View.outputView.printf("%d개를 구매했습니다.", lottos.size());
        View.outputView.println();
        lottos.stream()
                .forEach(lotto -> System.out.println(lotto));
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        View.outputView.println("당첨 통계");
        View.outputView.println("---------");

        View.outputView.printf("3개 일치 (%s원)- %d개", LottoUnitWinnings.THREE.getWinningPrice().toString() ,lottoStatistics.getNumberOfThreeEqualNumber());
        View.outputView.printf("4개 일치 (%s원)- %d개", LottoUnitWinnings.FOUR.getWinningPrice().toString() ,lottoStatistics.getNumberOfFourEqualNumber());
        View.outputView.printf("5개 일치 (%s원)- %d개", LottoUnitWinnings.FIVE.getWinningPrice().toString() ,lottoStatistics.getNumberOfFiveEqualNumber());
        View.outputView.printf("6개 일치 (%s원)- %d개", LottoUnitWinnings.SIX.getWinningPrice().toString() ,lottoStatistics.getNumberOfSixEqualNumber());
        View.outputView.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", lottoStatistics.calculateEfficiency(), lottoStatistics.calculateEfficiency() > 1 ? "이득" : "손해");
    }
}
