package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public static final String MONEY_IS_LESS_THAN_1000 = "구입 금액은 최소 1000원이어야 합니다.";

    private List<Lottery> lotteryList;

    private Money money;

    private MatchedResult matchedResult;

    public LottoGame() {
        this.matchedResult = new MatchedResult();
    }

    public LottoGame(Money money) {
        this.matchedResult = new MatchedResult();
        this.money = money;
        this.lotteryList = buy(money.getNumberOfLottery());
    }

    /**
     * 로또 용지 묶음을 만드는 메소드
     * @param numberOfLottery 구매할 로또 갯수
     * @return 발급된 용지 묶음
     */
    public List<Lottery> buy(int numberOfLottery) {
        lotteryList = new ArrayList<>();

        for (int i = 0; i < numberOfLottery; i++) {
            lotteryList.add(new Lottery());
        }

        return lotteryList;
    }

    /**
     * 로또들의 당첨 결과를 MatchedResult에 저장하는 메소드
     * @param generatedLotteries 현재 생성된 복권 리스트
     * @param winningLottery 당첨 복권
     */
    public void matchLottery(List<Lottery> generatedLotteries, WinningLottery winningLottery) {
        for (Lottery lottery : generatedLotteries) {
            matchedResult.putMatchedResult(lottery, lottery.match(winningLottery));
        }
    }

    /**
     * 수익률을 계산하는 메소드
     * @param money 구입 금액
     * @param profit 당첨 금액 합계
     * @return 수익률
     */
    public double calculateProfitRate(int money, int profit) {
        return (double) profit / money;
    }

    public int getProfit() {
        return this.matchedResult.getProfit();
    }

    public List<Lottery> getLotteryList() {
        return this.lotteryList;
    }

    public int getLotteryListSize() {
        return lotteryList.size();
    }

    public MatchedResult getMatchedResult() {
        return matchedResult;
    }

}
