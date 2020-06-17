package step2.view;

import step2.*;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static List<Lotto> getLotto(Money money) {
        print(money);
        List<Lotto> lottos = LottoMachine.buy(money);
        lottos.forEach(lotto -> System.out.println(lotto.getLotto()));
        return lottos;
    }

    public static void getResult(Money money) {
        print("당첨 통계");
        print("---------");
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.EMPTY))
                .forEach(rank -> {
            print(rank.getMatch() + "개 일치 (" + rank.getReward() + "원) = " + rank.getCount()+ "개");
        });
        print("총 수익률을 " + Statistic.getYield(money) + "입니다");
    }

    private static void print(Money money) {
        System.out.println(LottoMachine.getCount(money) + "개를 구매했습니다");
    }

    private static void print(String message) {
        System.out.println(message);
    }


}
