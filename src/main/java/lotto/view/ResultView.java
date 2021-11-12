package lotto.view;

import lotto.Bag;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private final int money;
    private final Lotto winLotto;
    private static final List<Double> PRIZE_LIST = Arrays.asList(
            0D,
            0D,
            0D,
            5000D,
            5_0000D,
            150_0000D,
            20_0000_0000D
    );

    public ResultView(int money, Lotto winLotto) {
        this.money = money;
        this.winLotto = winLotto;
    }

    public void showStatistics(Bag bag) {
        final List<Integer> result = bag.lottoResult(winLotto);

        for (int i = 3; i < result.size(); i++) {
            System.out.println(i + "개 일치" + "(" + PRIZE_LIST.get(i) + "원) - " + result.get(i) + "개");
        }
    }

    public void showYield(Bag bag) {
        final double yield = bag.yield(PRIZE_LIST, winLotto);
        System.out.println("총 수익률은 " + (yield / money) + "입니다.");
    }
}
