package step2;

public class LotteryMain {
    public static void main(String[] args) {
        LotteryController lotteryController = new LotteryController(new InputView(), new ResultView());
        lotteryController.request();
    }
}
