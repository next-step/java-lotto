package lotto.view.result.statistic;

import lotto.view.View;

public class ProfitView implements View {
    private final float profit;

    public ProfitView(float profit) {
        this.profit = profit;
    }

    @Override
    public void render() {
        String additional = profit < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "";
        System.out.printf("총 수익률은 %.2f입니다. %s", profit, additional);
    }
}
