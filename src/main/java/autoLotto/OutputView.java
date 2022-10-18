package autoLotto;

import static autoLotto.Match.*;
import static java.util.stream.IntStream.*;

public class OutputView {

    public static void outputQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void outputLottos(Lottos lottos) {
        range(0, lottos.getLottosSize())
                 .forEach(i -> System.out.println(lottos.getLotto(i)));
    }

    public static void outputResult(double result, int threeMatch, int fourMatch, int fiveMatch, int sixMatch) {
        System.out.println("\n당첨 통계\n" +
                "---------");
        System.out.println("3개 일치 (5000원)-"+ threeMatch + "개");
        System.out.println("4개 일치 (50000원)-"+ fourMatch + "개");
        System.out.println("5개 일치 (1500000원)-"+ fiveMatch + "개");
        System.out.println("6개 일치 (2000000000원)-"+ sixMatch + "개");

        System.out.print("총 수익률은 " + result +"입니다.");
        if (result < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
