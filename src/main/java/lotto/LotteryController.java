package lotto;


import java.util.ArrayList;
import java.util.List;
import static lotto.Const.LOTTERY_PRICE;

public class LotteryController {
    public Wallet wallet;
    public final WinStatistics winStatistics = new WinStatistics();
    private double earningRate;

    LotteryController() {}

    public void scanMoney() {
        String scanned = InputView.scan("Put your money.");
        attachWallet(new Wallet(Integer.parseInt(scanned)));
        this.wallet.numberOfLotteries = this.wallet.money / LOTTERY_PRICE;
    }

    public void attachWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void createLotteries() {
        this.wallet.createLotteries();
    }

    public void printLotteries() {
        ResultView.printLotteries(this.wallet.lotteries);
    }

    public void scanAnswer() {
        String scanned = InputView.scan("Put lottery answer.");
        this.wallet.answerNumbers = parseAnswerNumbers(scanned);
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
        for (Lottery lottery : this.wallet.lotteries) {
            int win = findWin(lottery.numbers, this.wallet.answerNumbers);
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
        this.earningRate = winStatistics.getEarningRate(this.wallet.money);
    }

    public void printEarningRate() {
        String payload = "Earning rate: " + this.earningRate;
        ResultView.print(payload);
    }

    public void printEarned() {
        String payload = winStatistics.DidEarn(this.wallet.money) + " (More than 1.0 means 'Earned')";
        ResultView.print(payload);
    }
}
