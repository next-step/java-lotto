package lottery.domain;

import java.util.ArrayList;
import java.util.List;

//TODO : 매직넘버 빼기
public class LotteryMachine {
    private static final Integer ONE_GAME_MONEY = 1000;
    private List<Lottery> lotteries = new ArrayList<>();
    private LotteryNumberSet lotteryNumberSet;
    public LotteryMachine(LotteryNumberSet lotteryNumberSet) {
        this.lotteryNumberSet = lotteryNumberSet;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public List<Lottery> purchaseLotteries(Integer inputMoney) {
        purchaseLottery(getPurchaseCount(inputMoney));
        return lotteries;
    }

    private int getPurchaseCount(Integer inputMoney) {
        return inputMoney / ONE_GAME_MONEY;
    }

    private void purchaseLottery(int purchaseCount) {
        for (int purchase = 0; purchase < purchaseCount; purchase++) {
            this.lotteries.add(new Lottery(lotteryNumberSet.extractRandomNumbers()));
        }
    }
    
    public LotteryResult checkWinning(List<Lottery> lotteries, List<Integer> winningNumbers) {
        List<Integer> comparedResults = new ArrayList<>();
        lotteries.forEach(lottery -> {
            comparedResults.add(compareNumbers(lottery, winningNumbers));
        });
        return new LotteryResult(comparedResults);
    }

    private int compareNumbers(Lottery lottery, List<Integer> WinningNumbers) {
        int matchedNumberCount = 0;
        for (Integer winningNumber : WinningNumbers) {
            matchedNumberCount += isContains(lottery.getNumbers(), winningNumber);
        }
        return matchedNumberCount;
    }

    private int isContains(List<Integer> lotteryNumbers,Integer winningNumber) {
        if(lotteryNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }
}
