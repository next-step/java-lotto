package lottoauto.view;

import lottoauto.domain.Lottos;
import lottoauto.domain.RatingStatics;

public class ResultView {
    private ResultView() {}

    public static void printLottosInfo(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        System.out.println(lottos);
    }

    public static void printRatingStatics(RatingStatics ratingStatics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(ratingStatics);
    }

    public static void printRateOfReturn(String rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

}
