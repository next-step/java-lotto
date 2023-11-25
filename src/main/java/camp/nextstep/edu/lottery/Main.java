package camp.nextstep.edu.lottery;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        int money = InputView.inputMoney();

        Lotteries lotteries = new Lotteries(money);
        OutputView.printPurchasedLotteries(lotteries);

        String winningLotteryNumbers = InputView.inputWinningLotteryNumbers();
        List<Integer> numbers = Arrays.stream(winningLotteryNumbers.split(","))
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        Lottery winningLottery = new Lottery(numbers);
        OutputView.printResult(lotteries, winningLottery);
    }
}
