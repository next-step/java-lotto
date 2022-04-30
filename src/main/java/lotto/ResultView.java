package lotto;

import java.util.List;

public class ResultView {
    public static void print(List<Lottery> lotteries) {
        System.out.printf("%d lotteries are purchased.\n", lotteries.size());
        for (Lottery lottery : lotteries) {
            System.out.println(lottery.numbers);
        }
    }
}
