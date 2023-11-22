package lotto_auto.io;

import lotto_auto.domain.MagicNumber;

import java.util.List;

public class OutputView {

    public OutputView() {
    }

    public OutputView(List<List<Integer>> lottoTotalNumberList) {
        System.out.println(lottoTotalNumberList.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottoTotalNumberList.size(); i++) {
            System.out.println(lottoTotalNumberList.get(i));
        }
    }

    public void printStatistics(int budget) {
        int totalProfit = MagicNumber.threeMatches * 5000
                + MagicNumber.fourMatches * 50000
                + MagicNumber.fiveMatches * 1500000
                + MagicNumber.sixMatches * 2000000000;
        float totalProfitRate = (float) totalProfit / budget;

        System.out.println("\n당첨 통계");
        System.out.println("------------");
        System.out.println("3개 일치 (5000원)- " + MagicNumber.threeMatches + "개");
        System.out.println("4개 일치 (50000원)- " + MagicNumber.fourMatches + "개");
        System.out.println("5개 일치 (1500000원)- " + MagicNumber.fiveMatches + "개");
        System.out.println("6개 일치 (2000000000원)- " + MagicNumber.sixMatches + "개");
        System.out.println("총 수익률은 " + totalProfitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임");
    }
}
