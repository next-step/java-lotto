package step3.view;

import step3.domain.Lotto;
import step3.domain.LottoResult;
import step3.domain.Lottos;

import java.util.List;

public class ResultView {

    public static void printBuyLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottoList();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-----------");

        int fifthCount = lottoResult.getGradeCount(5);
        int fourthCount = lottoResult.getGradeCount(4);
        int thirdCount = lottoResult.getGradeCount(3);
        int secondCount = lottoResult.getGradeCount(2);
        int firstCount = lottoResult.getGradeCount(1);
        double revenue = lottoResult.getRevenue();

        System.out.printf("3개 일치 (5000원)- %d개\n", fifthCount);
        System.out.printf("4개 일치 (50000원)- %d개\n", fourthCount);
        System.out.printf("5개 일치 (1500000원)- %d개\n", thirdCount);
        System.out.printf("5개 일치, 보너스 볼 일치(3000000원)- %d개\n", secondCount);
        System.out.printf("6개 일치 (2000000000원)- %d개\n", firstCount);
        System.out.println(revenue);
        System.out.printf("총 수익률은 %.2f입니다.", revenue);

        if (revenue < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
