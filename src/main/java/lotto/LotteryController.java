package lotto;


import java.util.ArrayList;
import java.util.List;

public class LotteryController {
    public Wallet wallet;
    public final WinStatistics winStatistics = new WinStatistics();

    LotteryController() {
    }

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

    public List<Reward> findWins(Lottery answer, int bonusNumber) {
        List<Reward> rewards = new ArrayList();
        for (Lottery lottery : this.wallet.lotteries) {
            Reward reward = lottery.findWin(answer, bonusNumber);
            rewards.add(reward);
        }
        return rewards;
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

    public void printEarningRate() {
        String payload = "Earning rate: " + wallet.getEarnedMoney(winStatistics.getEarnedMoney());
        ResultView.print(payload);
    }

    public void printEarned() {
        String payload = winStatistics.didEarn(new Money(1000)) + " (More than 1.0 means 'Earned')";
        ResultView.print(payload);
    }

    public int scanBonus() {
        String scanned = InputView.scan("Put bonus number.");
        return Integer.parseInt(scanned);
    }

//    public void findBonuses(int bonusNumber, Lottery answer) {
//        for (Lottery lottery : this.wallet.lotteries) {
//            lottery.findBonus(bonusNumber, answer);
//        }
//    }
}
