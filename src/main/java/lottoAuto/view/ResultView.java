package lottoAuto.view;

import lottoAuto.model.*;
import lottoAuto.vo.LottoResultVo;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {
    private static final int LOTTO_PRICE = 1000;

    public static int showAmount(int price) {
        int amount = price / LOTTO_PRICE;
        System.out.println(amount + "개를 구매했습니다.");
        return amount;
    }

    public static void showUserLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void showWinningStatistic(Map<Rank, Long> collect) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        collect.entrySet().stream().forEach(rankLongEntry -> System.out.println(Rank.getMessage(rankLongEntry.getKey()) + " - " + rankLongEntry.getValue()));
    }

    public static void showRevenue(double revenue){
        System.out.println("총 수익률은 "+revenue+"입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
