package lotto;


import java.util.ArrayList;
import java.util.List;

public class LotteryController {
    public Inventory inventory = new Inventory();
    public final WinStatistics winStatistics = new WinStatistics();

    LotteryController() {
    }

    public Money scanMoney() {
        String scanned = InputView.scan("Put your money.");
        return new Money(Integer.parseInt(scanned));
    }

    public void createLotteries(Money money) {
        this.inventory.createLotteries(money);
    }

    public void printLotteries() {
        this.inventory.printLotteries();
    }

    public Lottery scanAnswer() {
        String scanned = InputView.scan("Put lottery answer.");
        return new Lottery(parseAnswerNumbers(scanned));
    }

    public List<Integer> parseAnswerNumbers(String scanned) {
        return toIntegers(scanned.split("\\s*,\\s*"));
    }

    public List<Integer> toIntegers(String[] numberStrings) {
        List<Integer> list = new ArrayList();
        for (String numberString : numberStrings) {
            list.add(toInteger(numberString));
        }
        return list;
    }

    public int toInteger(String numberString) {
        int number = Integer.parseInt(numberString);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("answer number should be between 1 to 45.");
        }
        return number;
    }

    public List<Reward> findWins(Winning winning) {
        return this.inventory.findWins(winning);
    }

    public void saveWins(List<Reward> rewards) {
        for (Reward reward : rewards) {
            saveWin(reward);
        }
    }

    public void saveWin(Reward reward) {
        if (reward != Reward.Blank) {
            winStatistics.save(reward);
        }
    }

    public void printWinStatistics() {
        ResultView.printWinStatistics(this.winStatistics.toPayload());
    }

    public void printEarningRate(Money money) {
        String payload = "Earning rate: " + money.profitRate(winStatistics.getEarnedMoney());
        ResultView.print(payload);
    }

    public void printEarned(Money money) {
        ResultView.printEarned(money.profitRate(winStatistics.getEarnedMoney()));
    }

    public int scanBonus() {
        String scanned = InputView.scan("Put bonus number.");
        return Integer.parseInt(scanned);
    }
}
