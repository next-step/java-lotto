package step2;

import static step2.LotteryControllerTest.*;

public class LotteryMain {
    public static void main(String[] args) {
        LotteryController lotteryController = new LotteryController(new InputView(), new ResultView());
        lotteryController.request();
    }
}
