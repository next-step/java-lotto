package lotto;

import lotto.domain.LotteryMachine;

/**
 * Created by yusik on 2019/11/05.
 */
public class LotteryApplication {

    public static void main(String[] args) {
        LotteryMachine lotteryMachine = new LotteryMachine(System.in);
        lotteryMachine.run();
    }

}
