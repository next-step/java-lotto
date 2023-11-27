package step4.view;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import step4.constant.Prize;

public class ResultView {

    private static final String PROFIT = "이익";
    private static final String LOSS = "손해";
    private static final String SHOW_ROI_STAT_PROMPT = "당첨 통계";

    public static void showRewards(Map<Prize, Integer> summarize) {
        System.out.println(SHOW_ROI_STAT_PROMPT);
        for (Entry<Prize, Integer> prize : summarize.entrySet()) {
            print(prize);
        }
    }

    private static void print(Entry<Prize, Integer> prize ) {
        if (Prize.SECOND.name().equals(prize.getKey().name())) {
            System.out.println(prize.getKey().getCorrect() + "개 일치  보너스 볼 일치(" +
                               prize.getKey().getReward() + "원)- " + prize.getValue());
            return;
        }

        System.out.println(prize.getKey().getCorrect() + "개 일치 (" +
                           prize.getKey().getReward() + "원)- " + prize.getValue());
    }

    public static void showRoi(BigDecimal roi) {
        int i = roi.compareTo(new BigDecimal(1));
        if (i > 0) {
            System.out.println("총 수익률은 " + roi +
                               "입니다.(기준이 1이기 때문에 결과적으로 " + PROFIT + "라는 의미임)");
            return;
        }

        System.out.println("총 수익률은 " + roi +
                           "입니다.(기준이 1이기 때문에 결과적으로" + LOSS + "라는 의미임)");
    }
}
