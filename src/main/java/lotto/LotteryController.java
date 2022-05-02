package lotto;


import java.util.ArrayList;
import java.util.List;

public class LotteryController {
    public Money money;
    private int numberOfLotteries;
    public final List<Lottery> lotteries;
    private List<Integer> answerNumbers;
    public final WinStatistics winStatistics = new WinStatistics();
    private double earningRate;

    public LotteryController() {
        this.lotteries = new ArrayList<>();
    }

    public LotteryController(List<Lottery> lotteries, List<Integer> answerNumbers) {
        this.lotteries = lotteries;
        this.answerNumbers = answerNumbers;
    }

    public LotteryController(int money) {
        this.money = new Money(money);
        this.numberOfLotteries = this.money.price / 1000;
        this.lotteries = new ArrayList<>();
    }

    public void scanMoney() {
        String scanned = InputView.scan("Put your money.");
        this.money = new Money(Integer.parseInt(scanned));
        this.numberOfLotteries = this.money.price / 1000;
    }

    public int getNumberOfLotteries() {
        return this.numberOfLotteries;
    }

    public void createLotteries() {
        for (int i = 0; i < numberOfLotteries; i++) {
            lotteries.add(new Lottery());
        }
    }

    public void printLotteries() {
        ResultView.printLotteries(this.lotteries);
    }

    public void scanAnswer() {
        String scanned = InputView.scan("Put lottery answer.");
        this.answerNumbers = parseAnswerNumbers(scanned);
    }

    public List<Integer> parseAnswerNumbers(String scanned) {
        return toIntegers(scanned.split("\\s*,\\s*"));
    }

    public List<Integer> toIntegers(String[] split) {
        List<Integer> list = new ArrayList();
        for (String s : split) {
            list.add(toInteger(s));
        }
        return list;
    }

    public int toInteger(String s) {
        int number = Integer.parseInt(s);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("answer number should be between 1 to 45.");
        }
        return number;
    }

    public void findWins() {
        for (Lottery lottery : lotteries) {
            int win = findWin(lottery.numbers, this.answerNumbers);
            saveWin(win);
        }
    }

    public int findWin(List<Integer> numbers, List<Integer> answerNumbers) {
        int win = 0;
        for (int number : numbers) {
            win += matchNumber(answerNumbers, number);
        }
        return win;
    }

    private int matchNumber(List<Integer> answerNumbers, int number) {
        if (answerNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public void saveWin(int win) {
        if (win >= 3) {
            winStatistics.save(win);
        }
    }

    public void printWinStatistics() {
        ResultView.printWinStatistics(this.winStatistics.toPayload());
    }

    public void getEarningRate() {
        this.earningRate = winStatistics.getEarningRate(this.money.price);
    }

    public void printEarningRate() {
        String payload = "Earning rate: " + this.earningRate;
        ResultView.print(payload);
    }

    public void printEarned() {
        String payload = winStatistics.DidEarn(this.money.price) + " (More than 1.0 means 'Earned')";
        ResultView.print(payload);
    }
}
