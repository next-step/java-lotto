package lotto_step2.view;

import lotto_step2.model.PrizeMachine;

import java.util.EnumMap;
import java.util.List;

public class ResultView {

    public void printGameResult (List<PrizeMachine> gameResults) {
        EnumMap<PrizeMachine, Integer> matches = PrizeMachine.calcGameResult(gameResults);

        System.out.println("\n당첨 통계\n---------");
        System.out.println("3개 일치 (5000원)- " + matches.get(PrizeMachine.FOURTH) + "개");
        System.out.println("4개 일치 (50000원)- " + matches.get(PrizeMachine.THIRD) + "개");
        System.out.println("5개 일치 (1500000원)- " + matches.get(PrizeMachine.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + matches.get(PrizeMachine.FIRST) + "개");
    }

    public void printRevenue(List<PrizeMachine> gameResults, int money) {
        double rate = PrizeMachine.calcRevenue(gameResults, money);

        System.out.print(String.format("총 수익률은 %.2f 입니다. ", rate));
        if(rate < 1) {
            System.out.println("(기준이 1이기 때문에 1보다 작으면 결과적으로 손해라는 의미임)");
        }
    }
}
