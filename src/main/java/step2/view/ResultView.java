package step2.view;

import static step2.constant.Prize.ALL;
import static step2.constant.Prize.FIVE;
import static step2.constant.Prize.FOUR;
import static step2.constant.Prize.THREE;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

public class ResultView {

    private static final String SHOW_ROI_STAT_PROMT = "당첨 통계";


    public static void showRewards(Map<String, Integer> sortedPrize) {
        System.out.println(SHOW_ROI_STAT_PROMT);
        for (Entry<String, Integer> p : sortedPrize.entrySet()) {
            if (THREE.name().equals(p.getKey())) {
                System.out.println(THREE.getComment() + p.getValue() + "개");
            }

            if (FOUR.name().equals(p.getKey())) {
                System.out.println(FOUR.getComment() + p.getValue() + "개");
            }

            if (FIVE.name().equals(p.getKey())) {
                System.out.println(FIVE.getComment() + p.getValue() + "개");
            }

            if (ALL.name().equals(p.getKey())) {
                System.out.println(ALL.getComment() + p.getValue() + "개");
            }
        }

    }

    public static void showRoi(BigDecimal roi) {
        int i = roi.compareTo(new BigDecimal(1));
        if (i > 0) {
            System.out.println("총 수익률은 " + roi + "입니다.(기준이 1이기 때문에 결과적으로 이익라는 의미임)");
            return;
        }

        if (i < 0) {
            System.out.println("총 수익률은 " + roi + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
            return;
        }

        System.out.println("총 수익률은 " + roi + "입니다.(기준이 1이기 때문에 결과적으로 수익이 없다는 의미임)");
    }
}
