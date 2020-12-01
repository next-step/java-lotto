package step2;

import java.util.StringJoiner;

public class ResultView {
    public static void printLottoCnt(int lottoCnt) {
        System.out.println(lottoCnt + "개를 구매했습니다.");
    }


    public static void printLottoNumber(Lotto lotto) {
        StringJoiner numberString = new StringJoiner(", ");
        for(int number: lotto.getNumberList()){
            numberString.add(Integer.toString(number));
        }
        System.out.println("[" + numberString.toString() + "]");
    }

    public static void printResult(Lottos lottos, int money){
        System.out.println("당첨 통계");
        System.out.println("------------------");

        for (int i = 3; i <= 6; i ++) {
            System.out.println((i) + "개 일치 (" + RewardBoard.getReward(i).getReward() + "원)- " + Statistic.results[i-1].toString() + "개");
        }

        System.out.println("총 수익률은 " + Statistic.getMargin(money) + "입니다.");
    }
}
