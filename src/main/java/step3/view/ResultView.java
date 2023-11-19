package step3.view;

import static step2.constant.Prize.FIFTH;
import static step2.constant.Prize.FIRST;
import static step2.constant.Prize.FOURTH;
import static step2.constant.Prize.SECOND;
import static step2.constant.Prize.THIRD;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

public class ResultView {

    private static final String PROFIT = "이익";
    private static final String LOSS = "손해";
    private static final String SHOW_ROI_STAT_PROMPT = "당첨 통계";


    public static void showRewards(Map<String, Integer> summarize) {
        System.out.println(SHOW_ROI_STAT_PROMPT);
        for (Entry<String, Integer> prize : summarize.entrySet()) {
            print(prize);
        }
    }

    private static void print(Entry<String, Integer> prize) {
        if (FIRST.name().equals(prize.getKey())) {
            System.out.println(FIRST.getCorrect() + "개 일치 (" + FIRST.getReward() + "원)- " + prize.getValue());
        }

        if (SECOND.name().equals(prize.getKey())) {
            System.out.println(SECOND.getCorrect() + "개 일치 , 보너스 볼 일치(" + SECOND.getReward() + "원)- " + prize.getValue());
        }

        if (THIRD.name().equals(prize.getKey())) {
            System.out.println(THIRD.getCorrect() + "개 일치 (" + THIRD.getReward() + "원)- " + prize.getValue());
        }

        if (FOURTH.name().equals(prize.getKey())) {
            System.out.println(FOURTH.getCorrect() + "개 일치 (" + FOURTH.getReward() + "원)- " + prize.getValue());
        }

        if (FIFTH.name().equals(prize.getKey())) {
            System.out.println(FIFTH.getCorrect() + "개 일치 (" + FIFTH.getReward() + "원)- " + prize.getValue());
        }
    }

    public static void showRoi(BigDecimal roi) {
        int i = roi.compareTo(new BigDecimal(1));
        String result = i > 0 ?  PROFIT : LOSS;
        System.out.println("총 수익률은 " + roi + "입니다.(기준이 1이기 때문에 결과적으로" + result + "라는 의미임)");
    }
}
