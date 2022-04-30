package lotto;


import java.util.ArrayList;
import java.util.List;

public class LotteryController {
    public Money money;
    private int numberOfLotteries;
    public final List<Lottery> lotteries = new ArrayList<>();
    private List<Integer> answerNumbers;
    public final WinStatistics winStatistics = new WinStatistics();

    public LotteryController() {
    }

    public LotteryController(int money) {
        this.money = new Money(money);
        this.numberOfLotteries = this.money.price / 1000;
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
        ResultView.print(this.lotteries);
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
            findWin(lottery.numbers, this.answerNumbers);
        }
    }

    public void findWin(List<Integer> numbers, List<Integer> answerNumbers) {
        int counter = 0;
        for (int number : numbers) {
            if (answerNumbers.contains(number)) {
                counter++;
            }
        }
        if (counter >= 3) {
            winStatistics.save(counter);
        }
    }
}
