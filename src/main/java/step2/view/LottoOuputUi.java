package step2.view;

import java.util.List;

public class LottoOuputUi {
    public void printLottoCount(String lottoPurchaseQty) {
        System.out.println(lottoPurchaseQty + "개를 구매했습니다.");
    }

    public void printWinningStatistics(List<Integer> winningCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

//        System.out.println("3개 일치 (5000원) - " + winningCount.get(0) + "개");
//        System.out.println("4개 일치 (50000원) -" + +"개");
//        System.out.println("5개 일치 (1500000원)-"++"개");
//        System.out.println("6개 일치 (2000000000원) - "++"개");
    }

    public void printTotalReturn(int yield) {
        System.out.println("총 수익률은" + yield + "입니다");
    }
}
