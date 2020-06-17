package step2.view;

import step2.*;

import java.util.List;

public class OutputView {

    public static void getLotto(Money money, List<Lotto> lottos) {
        print(money);
        lottos.forEach(lotto -> print(lotto));
    }

    public static void getResult(Money money) {
        print("당첨 통계\n---------");
        Rank.getCounted()
            .forEach(OutputView::printMatched);
        print("총 수익률을 " + Statistic.getYield(money) + "입니다");
    }

    private static void printMatched(Rank rank) {
        print(rank.getMatch() + "개 일치 (" + rank.getReward() + "원) = " + rank.getCount()+ "개");
    }

    private static void print(Money money) {
        System.out.println(LottoMachine.getCount(money) + "개를 구매했습니다");
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void print(Lotto lotto) { System.out.println(lotto.getLotto()); }


}
