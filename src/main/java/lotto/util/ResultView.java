/*
 * UI 출력을 담당하는 클래스
 * */
package lotto.util;

import lotto.domain.Lottos;
import lotto.domain.Winning;

public class ResultView {

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printResult(Winning winning) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(winning.toString());
    }

    public static void printYield(double yield) {
        System.out.print("총 수익률은" + yield + "입니다.");
        if (yield <= 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
            return;
        }
        System.out.print("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
    }
}
