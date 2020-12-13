package step4.View;

import step4.RewardBoard;
import step4.Statistic;
import step4.VO.Lotto;
import step4.VO.LottoNumber;
import step4.VO.Lottos;
import step4.VO.Money;

import java.util.StringJoiner;

public class ResultView {
    public static void printLottoCnt(int lottoCnt) {
        System.out.println(lottoCnt + "개를 구매했습니다.");
    }


    public static void printLottoNumber(Lotto lotto) {
        StringJoiner numberString = new StringJoiner(", ");
        for (LottoNumber number: lotto.getNumberList()) {
            numberString.add(number.toString());
        }
        System.out.println("[" + numberString.toString() + "]");
    }

    public static void printResult(Money money, Statistic statistic) {
        System.out.println("당첨 통계");
        System.out.println("------------------");

        for (int i = statistic.getResultLength() - 2; i >= 0; i --) {
            printWinningCntResult(i, statistic);
        }

        System.out.println("총 수익률은 " + statistic.getMargin(money) + "입니다.");
    }

    public static void printWinningCntResult(int index, Statistic statistic) {
        //
        int winningCnt = statistic.getWinningCntByRank(index+1);

        if (index != 1) {
            int rank = statistic.getRankByWinningCnt(winningCnt, false);
            System.out.println((winningCnt) + "개 일치 (" + RewardBoard.getReward(rank).getReward() + "원)- " + statistic.getResultByIndex(index) + "개");
        }

        if (index == 1) {
            System.out.println("5개 일치, 보너스 볼 일치 (" + RewardBoard.getReward(2).getReward() + "원)- " + statistic.getResultByIndex(index) + "개");
        }
    }

    public static void printLottoList(Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList()) {
            ResultView.printLottoNumber(lotto);
        }
    }
}
