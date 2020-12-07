package autolotto.view;

import autolotto.model.LottosComparer;

public class ResultView {

    public static void viewStatistic(LottosComparer lottosComparer){
        System.out.println("3개 일치 (5000원) - " + lottosComparer.getMatchingCount(3) + "개");
        System.out.println("4개 일치 (50000원) - " + lottosComparer.getMatchingCount(4) + "개");
        System.out.println("5개 일치 (1500000원) - " + lottosComparer.getMatchingCount(5) + "개");
        System.out.println("6개 일치 (2000000000원) - " + lottosComparer.getMatchingCount(6) + "개");
    }

    public static void viewProfitRate(float profitRate){
        System.out.println("총 수익률은 " + profitRate + "입니다.(1이 본전을 의미한다)");
    }
}
