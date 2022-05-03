package lotto;


import java.util.ArrayList;
import java.util.List;

public class LotteryController {
    public Wallet wallet;
    public final WinStatistics winStatistics = new WinStatistics();

    LotteryController() {}

    public void scanMoney() {
        String scanned = InputView.scan("Put your money.");
        attachWallet(new Wallet(Integer.parseInt(scanned)));
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

    public Answer scanAnswer() {
        String scanned = InputView.scan("Put lottery answer.");
        return new Answer(parseAnswerNumbers(scanned));
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

    public void findWins(Answer answer) {
        for (Lottery lottery : this.wallet.lotteries) {
            int win = findWin(lottery.numbers, answer.numbers);
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

    public void printEarningRate() {
        String payload = "Earning rate: " + winStatistics.getEarningRate(this.wallet.money);
        ResultView.print(payload);
    }

    public void printEarned() {
        String payload = winStatistics.DidEarn(this.wallet.money) + " (More than 1.0 means 'Earned')";
        ResultView.print(payload);
    }
}
