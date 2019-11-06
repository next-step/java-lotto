package lotto;

/**
 * Created by yusik on 2019/11/05.
 */
public class LotteryApplication {

    public static void main(String[] args) {
        LotteryController lotteryMachine = new LotteryController(System.in, System.out);
        lotteryMachine.run();
    }

}
