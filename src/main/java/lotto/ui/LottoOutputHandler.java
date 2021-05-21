package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseBudget;
import lotto.domain.LottoWinNumbers;
import lotto.domain.Lottos;

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
    }

    public void printWinnerStatistics(Lottos lottos, LottoWinNumbers winNumbers) {
        System.out.println("당첨 통계\n---------");
        System.out.println("3개 일치 (5000원)- " + 1 + "개");
        System.out.println("4개 일치 (5000원)- " + 1 + "개");
        System.out.println("5개 일치 (5000원)- " + 1 + "개");
        System.out.println("6개 일치 (5000원)- " + 1 + "개");
    }

}
