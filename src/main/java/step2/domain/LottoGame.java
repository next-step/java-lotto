package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    public static final String MONEY_IS_LESS_THAN_1000 = "구입 금액은 최소 1000원이어야 합니다.";

    private List<Lottery> lotteryList;

    private Money money;

    private MatchedResult matchedResult;

    public LottoGame() {
        this.matchedResult = new MatchedResult();
    }

    public LottoGame(int amount) {
        this.matchedResult = new MatchedResult();
        this.money = new Money(amount);
        this.buy(money.getNumberOfLottery());
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

    public List<Lottery> getLotteryList() {
        return this.lotteryList;
    }

    /**
     * 로또들의 당첨 결과를 Map으로 리턴하는 메소드
     * @param generatedLotteries 현재 생성된 복권 리스트
     * @param winningLottery 당첨 복권
     * @return 각 복권들의 당첨 결과 Map
     */
    public MatchedResult matchLottery(List<Lottery> generatedLotteries, WinningLottery winningLottery) {

        for (Lottery lottery : generatedLotteries) {
            matchedResult.putMatchedResult(lottery, lottery.match(winningLottery));
        }

        return matchedResult;
    }

    /**
     * 수익률을 계산하는 메소드
     * @param money 구입 금액
     * @param matchedResult 로또 매칭 결과
     * @return 수익률
     */
    public double calculateProfitRate(int money, MatchedResult matchedResult) {
        return (double) matchedResult.getProfit() / money;
    }

}
