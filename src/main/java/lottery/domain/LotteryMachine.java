package lottery.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {
    private static final Integer ONE_GAME_MONEY = 1000;
    private List<Lottery> lotteries = new ArrayList<>();

    public LotteryMachine() {
        // lotteryNumberSet 얘는 어디선가 new를 안해주면.. 동작하지 않습니다.
        // 여기서 넘버셋도 같이 new 해줘도 될까요?
        // 아니면 설계가 잘못된 걸까요ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
        new LotteryNumberSet();
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public List<Lottery> purchaseLotteries(Integer inputMoney) {
        for (int purchase = 0; purchase < PurchaseCount(inputMoney); purchase++) {
            lotteries.add(purchaseLottery());
        }
        return lotteries;
    }

    private int PurchaseCount(Integer inputMoney) {
        return inputMoney / ONE_GAME_MONEY;
    }

    private Lottery purchaseLottery() {
        return new Lottery();
    }

    public LotteryResult checkWinning(List<Lottery> lotteries, Lottery winningNumbers) {
        List<Integer> comparedResults = new ArrayList<>();
        lotteries.forEach(lottery -> {
            comparedResults.add(compareNumbers(lottery, winningNumbers));
        });
        return new LotteryResult(comparedResults);
    }

    private int compareNumbers(Lottery lottery, Lottery winningNumbers) {
        return countMatchedNumber(lottery, winningNumbers);
    }

    private int countMatchedNumber(Lottery lottery, Lottery winningNumber) {
        return lottery.winCheck(winningNumber);
    }
}
