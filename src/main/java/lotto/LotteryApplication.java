package lotto;

/**
 * Created by yusik on 2019/11/05.
 */
public class LotteryApplication {

    public static void main(String[] args) {
        LotteryMachine lotteryMachine = new LotteryMachine(System.in, System.out);
        lotteryMachine.run();
    }

}
