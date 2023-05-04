package lottery.view;

import lottery.domain.Lottery;

import java.util.List;
import java.util.stream.Collectors;

public class NumberOfLotteryOutputView implements OutputView<List<Lottery>> {
    @Override
    public void print(List<Lottery> output) {
        printNumberOfLottery(output);
        printLotteries(output);
    }

    private void printNumberOfLottery(List<Lottery> output) {
        System.out.printf("%d개를 구매했습니다.\n", output.size());
    }

    private void printLotteries(List<Lottery> output) {
        for (Lottery lottery : output) {
            printLottery(lottery);
        }
    }

    private void printLottery(Lottery lottery) {
        System.out.printf("[%s]\n", lottery.numbers().stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
