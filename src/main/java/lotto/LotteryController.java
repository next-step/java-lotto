package lotto;


import java.util.ArrayList;
import java.util.List;

public class LotteryController {
    public Wallet wallet;
    public final WinStatistics winStatistics = new WinStatistics();

    LotteryController() {}

    public void scanMoney() {
        String scanned = InputView.scan("Put your money.");
        attachWallet(new Wallet(new Money(Integer.parseInt(scanned))));
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

    public void findWins(Lottery answer) {
        for (Lottery lottery : this.wallet.lotteries) {
            int win = lottery.findWin(answer);
            saveWin(win);
        }
    }

    public void saveWin(int win) {
        if (win >= 3) {
            winStatistics.save(win);
        }
    }

    public void printWinStatistics() {
        ResultView.printWinStatistics(this.winStatistics.toPayload());
    }

    public void printEarningRate() {
        String payload = "Earning rate: " + wallet.getEarnedMoney(winStatistics.getEarnedMoney());
        ResultView.print(payload);
    }

    public void printEarned() {
        String payload = winStatistics.didEarn(new Money(1000)) + " (More than 1.0 means 'Earned')";
        ResultView.print(payload);
    }
}
