package step3;

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

    public static void printResult(int money) {
        System.out.println("당첨 통계");
        System.out.println("------------------");

        for (int i = 1; i < Statistic.results.length; i ++) {
            printWinningCntResult(i);
        }

        System.out.println("총 수익률은 " + Statistic.getMargin(money) + "입니다.");
    }

    public static void printWinningCntResult(int index) {
        //
        int winningCnt = index + 2;
        if (index == 4) {
            System.out.println("5개 일치, 보너스 볼 일치 (" + RewardBoard.getReward(2).getReward() + "원)- " + Statistic.results[index].toString() + "개");

        }
        int rank = RewardBoard.getRankByWinningCnt(winningCnt, false);
        System.out.println((winningCnt) + "개 일치 (" + RewardBoard.getReward(rank).getReward() + "원)- " + Statistic.results[index].toString() + "개");
    }

    public static void printLottoList(Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList()) {
            ResultView.printLottoNumber(lotto);
        }
    }
}
