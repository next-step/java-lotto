package step2.view;

import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.WinningLotto;

import java.util.List;

public class ResultView {

    public static void printBuyLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottoList();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void printResult(WinningLotto winningLotto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-----------");

        int fourthCount = winningLotto.getGradeCount(4);
        int thirdCount = winningLotto.getGradeCount(3);
        int fifthCount = winningLotto.getGradeCount(5);
        int firstCount = winningLotto.getGradeCount(1);
        double revenue = winningLotto.getRevenue();

        System.out.printf("3개 일치 (5000원)- %d개\n", fifthCount);
        System.out.printf("4개 일치 (50000원)- %d개\n", fourthCount);
        System.out.printf("5개 일치 (1500000원)- %d개\n", thirdCount);
        System.out.printf("6개 일치 (2000000000원)- %d개\n", firstCount);
        System.out.printf("총 수익률은 %.2f입니다.", revenue);

        if (revenue < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
