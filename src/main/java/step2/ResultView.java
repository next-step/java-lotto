package step2;

import java.util.Arrays;
import java.util.List;
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

    public static void printResult(int money){
        System.out.println("당첨 통계");
        System.out.println("------------------");

        Integer[] rewardList = Statistic.rewardList;

        for (int i = 0; i < rewardList.length; i ++) {
            System.out.println((i + 3) + "개 일치 (" + Statistic.rewardList[i].toString() + "원)- " + Statistic.results[i].toString() + "개");
        }

        System.out.println("총 수익률은 " + Statistic.getMargin(money) + "입니다.");
    }
}
