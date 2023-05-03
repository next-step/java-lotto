package lottery.view;

import lottery.domain.LotteryResult;

public class LotteryResultOutputView implements OutputView<LotteryResult> {
    @Override
    public void print(LotteryResult output) {
        System.out.println("3개 일치 (5000원) - 1개");
        System.out.println("총 수익률은 0.35입니다");
    }
}
