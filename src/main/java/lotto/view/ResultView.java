package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import java.util.Collections;
import java.util.List;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");

        System.out.println(lottos.toString());
    }

    public static void printResults(List<LottoResult> results) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + Collections.frequency(results, LottoResult.FourthPrize));
        System.out.println("4개 일치 (50000원)- " + Collections.frequency(results, LottoResult.ThirdPrize));
        System.out.println("5개 일치 (1500000원)- " + Collections.frequency(results, LottoResult.SecondPrize));
        System.out.println("6개 일치 (2000000000원)- " + Collections.frequency(results, LottoResult.FirstPrize));
    }

    public static void printYield(double calculateYield) {
        System.out.println("총 수익률은 " + String.format("%.2f", calculateYield) + "입니다");
    }
}
