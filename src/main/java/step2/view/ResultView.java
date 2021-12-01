package step2.view;

import step1.domain.Number;
import step2.domain.Lotteries;
import step2.domain.Lottery;

import java.util.stream.Collectors;

public class ResultView {
    public static void printLotteries(Lotteries lotteries) {
        for (Lottery lottery : lotteries.getLotteries()) {
            String str = lottery.getLottery().stream()
                    .map(n -> String.valueOf(n.getNumber()))
                    .collect(Collectors.joining(", "));

            System.out.println(String.format("[%s]", str));
        }
    }

    public static void printResult(Number number) {
        System.out.println(number.getNumber());
    }
}
