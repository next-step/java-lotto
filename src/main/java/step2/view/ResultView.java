package step2.view;

import java.util.List;

public class ResultView {
    public static void view(List<List> lottos) {
        StringBuilder sb = new StringBuilder();
        for(List lotto : lottos) {
            sb.append(lotto.toString() + "\n");
        }
        System.out.println(sb.toString());
    }

    public static void result(int[] result, float revenue) {
        System.out.println("\n당첨 통계");
        System.out.println("------------");
        System.out.println("3개 일치 (5000원) - " + result[0] + "개");
        System.out.println("4개 일치 (50000원) - " + result[1] + "개");
        System.out.println("5개 일치 (1500000원) - " + result[2] + "개");
        System.out.println("6개 일치 (20000000000원) - " + result[3] + "개");
        System.out.println("총 수익률은 " + revenue + "입니다.(기준이 1이기 떄문에 결과적으로 손해라는 의미)");
    }
}
