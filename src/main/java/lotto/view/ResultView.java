package lotto.view;

import lotto.Bag;
import lotto.Lotto;
import lotto.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private final int money;
    private final Lotto winLotto;

    public ResultView(int money, Lotto winLotto) {
        this.money = money;
        this.winLotto = winLotto;
    }

    public void showStatistics(Bag bag) {
        final Map<Prize, Integer> result = bag.lottoResult(winLotto);

        for (Prize prize : result.keySet().stream().sorted().collect(Collectors.toList())) {
            System.out.println(prize.hitCount() + "개 일치" + "(" + prize.money() + "원) - " + result.get(prize) + "개");
        }
    }

    public void showYield(Bag bag) {
        final double yield = bag.yield(winLotto);
        System.out.println("총 수익률은 " + (yield / money) + "입니다.");
    }
}
