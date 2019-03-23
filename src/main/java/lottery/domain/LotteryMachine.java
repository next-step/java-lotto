package lottery.domain;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class LotteryMachine {
    private static final Integer ONE_GAME_MONEY = 1000;
    private static final List<Lottery> lotteries = new ArrayList<>();

    public LotteryMachine() {
        // lotteryNumberSet 얘는 어디선가 new를 안해주면.. 동작하지 않습니다.
        // 여기서 넘버셋도 같이 new 해줘도 될까요?
        // 아니면 설계가 잘못된 걸까요ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
        new LotteryNumberSet();
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    // TODO : 새벽내내 했는데.. 잘 모르겠어서 질문하려고 커밋했습니다..
    // ㅎㅎㅎㅎㅎ;;;
    // 여러장 구매시 단위 테스트에서는 2개 리스트의 값이 다른데,
    // 왜 콘솔메인으로만 돌리면 리스트의 값이 동일하게 나오는지 잘 모르겠습니다..
    // 제가 뭘 잘못하고 있을까요;;;;;;
    public List<Lottery> purchaseLotteries(Integer inputMoney) {
        int hihi = PurchaseCount(inputMoney);
        System.out.println("히히 "+ hihi);
        for (int purchase = 0; purchase < hihi; purchase++) {
            lotteries.add(purchaseLottery());
        }
        return lotteries;
    }

//    public List<Lottery> purchaseLotteries(Integer inputMoney) {
//        System.out.println("ㅎ 후후후  " + PurchaseCount(inputMoney));
//        purchaseLottery(3);
////        System.out.println("그만하고 싶어 ㅎㅎㅎ" + purchaseLottery(PurchaseCount(inputMoney)));
//        return lotteries;
//    }

    private int PurchaseCount(Integer inputMoney) {
        return inputMoney / ONE_GAME_MONEY;
    }

    private Lottery purchaseLottery() {
        Lottery to = new Lottery();
        System.out.println("모기놈!!!" + to.toString());
        return to;
    }

//    private List<Lottery> purchaseLottery(int purchaseCount) {
//        for (int purchase = 0; purchase < purchaseCount; purchase++) {
//            Lottery to = new Lottery();
//            System.out.println("모기놈!!!" + to.toString());
//            lotteries.add(to);
//        }
//        return lotteries;
//    }
    
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
        return lottery.countMatchNumber(winningNumber);
    }
}
