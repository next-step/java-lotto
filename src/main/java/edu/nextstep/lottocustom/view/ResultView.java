package edu.nextstep.lottocustom.view;

import edu.nextstep.lottocustom.domain.Prize;
import edu.nextstep.lottocustom.domain.Ticket;
import edu.nextstep.lottocustom.domain.Tickets;
import edu.nextstep.lottocustom.domain.WinningResult;

import java.util.Arrays;

public class ResultView {
    public static void printTickets(Tickets tickets) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("수동으로 ")
                .append(tickets.numberOfCustomTickets())
                .append("장, 자동으로 ")
                .append(tickets.getNumberOfAutoTickets())
                .append("장을 구매했습니다.");

        for (Ticket ticket : tickets.getTickets()) {
            stringBuilder.append(System.lineSeparator())
                    .append(ticket);
        }

        String result = stringBuilder.toString();
        System.out.println(result);
    }

    public static void printWinningResult(WinningResult winningResult) {


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
                .append(winningResult.getRateOfReturn())
                .append("입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
                .toString();

        System.out.println(result);
    }
}
