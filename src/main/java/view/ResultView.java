package view;

import domain.LottoStatistics;

public class ResultView {
    public static void printHowLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoList(String result) {
        System.out.println(result);
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------------");
        System.out.println("수익률 :" + lottoStatistics.statistics());
    }

}
