package edu.nextstep.lottobonusnumber.view;

import edu.nextstep.lottobonusnumber.domain.Prize;
import edu.nextstep.lottobonusnumber.domain.Ticket;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String SECOND_WORD = "개 일치, 보너스 볼 일치(";
    private static final String EXCEPT_SECOND_WORD = "개 일치 (";

    public static void printTickets(List<Ticket> tickets) {
        System.out.println(tickets.size() + " 개를 구매하셨습니다.");
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printWinningResult(Map<Prize, Integer> winningResult, double rateOfReturn) {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---------");

        Arrays.stream(Prize.values())
                .filter((prize) -> !prize.equals(Prize.LOSE))
                .map((prize) -> makeString(winningResult, prize))
                .forEach(System.out::println);

        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", + rateOfReturn);
    }

    private static String makeString(Map<Prize, Integer> winningResult, Prize prize) {
        StringBuilder sb = new StringBuilder();
        return sb.append(prize.getCountOfMatch())
                .append(ifSecondOrNot(prize))
                .append(prize.getWinningPrize())
                .append("원)- ")
                .append(winningResult.getOrDefault(prize, 0))
                .append("개")
                .toString();
    }

    private static String ifSecondOrNot(Prize prize) {
        if (prize.equals(Prize.SECOND)) {
            return SECOND_WORD;
        }
        return EXCEPT_SECOND_WORD;
    }
}
