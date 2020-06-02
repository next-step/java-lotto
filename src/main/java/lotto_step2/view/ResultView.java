package lotto_step2.view;

import lotto_step2.model.PrizeMachine;

import java.util.EnumMap;
import java.util.List;

import static lotto_step2.LottoConstants.*;
import static lotto_step2.model.PrizeMachine.*;

public class ResultView {

    private EnumMap<PrizeMachine, Integer> matches = new EnumMap<>(PrizeMachine.class);

    public void printGameResult (List<PrizeMachine> gameResults) {
        calcGameResult(gameResults);

        System.out.println("\n당첨 통계\n---------");
        System.out.println("3개 일치 (5000원)- " + this.matches.get(PrizeMachine.FOURTH) + "개");
        System.out.println("4개 일치 (50000원)- " + this.matches.get(PrizeMachine.THIRD) + "개");
        System.out.println("5개 일치 (1500000원)- " + this.matches.get(PrizeMachine.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + this.matches.get(PrizeMachine.FIRST) + "개");
    }

    private void calcGameResult(List<PrizeMachine> gameResults) {
        this.matches.put(FOURTH, (int) gameResults.stream()
                .filter(result -> result.getMatchCount() == MATCH_PRIZE_FOURTH)
                .count());

        this.matches.put(THIRD, (int) gameResults.stream()
                .filter(result -> result.getMatchCount() == MATCH_PRIZE_THIRD)
                .count());

        this.matches.put(SECOND, (int) gameResults.stream()
                .filter(result -> result.getMatchCount() == MATCH_PRIZE_SECOND)
                .count());

        this.matches.put(FIRST, (int) gameResults.stream()
                .filter(result -> result.getMatchCount() == MATCH_PRIZE_FIRST)
                .count());
    }

    public void printRevenue(List<PrizeMachine> gameResults, int money) {
        double rate = PrizeMachine.calcRevenue(gameResults, money);

        System.out.print(String.format("총 수익률은 %.2f 입니다. ", rate));
        if(rate < 1) {
            System.out.println("(기준이 1이기 때문에 1보다 작으면 결과적으로 손해라는 의미임)");
        }
    }
}
