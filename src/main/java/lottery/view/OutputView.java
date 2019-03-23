package lottery.view;

import lottery.domain.Lottery;
import lottery.domain.LotteryResult;

import java.util.List;

public class OutputView {

    public static void printPurchasedLotties(List<Lottery> lotteries) {
        System.out.println(lotteries.size() + "개를 구입하였습니다");
        lotteries.forEach(lottery -> System.out.println(lottery.getString()));
    }

    public static void printWinningResult(LotteryResult lotteryResult) {
        System.out.println("당첨 결과 조회");
        System.out.println("==================================");

        for (LotteryResult.RANK rank : LotteryResult.RANK.values()) {
            System.out.println(rank.getMatched() +"개 일치(" + rank.getPrice()+ "원)- " + lotteryResult.getResultDatas().get(rank.getMatched()) + "개");
        }
        System.out.println("총 수익률은 " + lotteryResult.getEarningRates()+ " 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
