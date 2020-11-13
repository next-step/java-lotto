package step2;

import step2.view.InputView;
import step2.view.ResultView;

public class LotteryMain {
    public static void main(String[] args) {
        LotteryController lotteryController = new LotteryController(new InputView(), new ResultView());
        lotteryController.request();
    }
}
