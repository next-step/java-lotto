package lotto.ui;

import lotto.domain.*;

import java.util.Iterator;

public class LottoOutputHandler {

    public void printCount(int count) {
        System.out.println(count+"개를 구매했습니다.");
    }

    public void printBought(Lottos lottos) {
        Iterator<Lotto> it = lottos.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
        System.out.println();
    }

    public void printWinnerStatistics(LottoResultPack resultPack) {
        System.out.println("\n당첨 통계\n--------");
        System.out.println("3개 일치 (" + LottoResult.MATCH_3.profit() + "원)- " + resultPack.countOf(LottoResult.MATCH_3) + "개");
        System.out.println("4개 일치 (" + LottoResult.MATCH_4.profit() + "원)- " + resultPack.countOf(LottoResult.MATCH_4) + "개");
        System.out.println("5개 일치 (" + LottoResult.MATCH_5.profit() + "원)- " + resultPack.countOf(LottoResult.MATCH_5) + "개");
        System.out.println("6개 일치 (" + LottoResult.MATCH_6.profit() + "원)- " + resultPack.countOf(LottoResult.MATCH_6) + "개");
    }

    public void printProfitRatio(double calculateProfitRatio) {
        System.out.print("총 수익률은 " + calculateProfitRatio + "입니다. ");
        if (calculateProfitRatio >= 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해는 아니라는 의미임)");
            return;
        }
        System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
