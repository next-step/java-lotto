package edu.nextstep.lottobonusnumber.view;

import edu.nextstep.lottobonusnumber.domain.Prize;
import edu.nextstep.lottobonusnumber.domain.Tickets;

import java.util.Arrays;
import java.util.Map;

public class ResultView {
    public static void printTickets(Tickets tickets) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tickets.count())
                .append("개를 구매했습니다.");

        tickets.stream()
                .forEach((ticket) -> {
                    stringBuilder.append(System.lineSeparator())
                            .append(ticket);
                });

        String result = stringBuilder.toString();
        System.out.println(result);
    }

    public static void printWinningResult(Map<Prize, Integer> winningResult, double rateOfReturn) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(System.lineSeparator())
                .append("당첨 통계")
                .append(System.lineSeparator())
                .append("---------")
                .append(System.lineSeparator());

        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.LOSE))
                .forEach(prize -> {
                    stringBuilder.append(prize)
                            .append(winningResult.get(prize))
                            .append("개")
                            .append(System.lineSeparator());
                });

        String result = stringBuilder.append("총 수익률은 ")
                .append(rateOfReturn)
                .append("입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
                .toString();

        System.out.println(result);
    }
}
