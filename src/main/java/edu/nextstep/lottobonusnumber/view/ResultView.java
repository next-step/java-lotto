package edu.nextstep.lottobonusnumber.view;

import edu.nextstep.lottobonusnumber.domain.Prize;
import edu.nextstep.lottobonusnumber.domain.Tickets;

import java.util.Arrays;
import java.util.Map;

public class ResultView {

    private static final String SECOND_WORD = "개 일치, 보너스 볼 일치(";
    private static final String EXCEPT_SECOND_WORD = "개 일치 (";

    public static void printTickets(Tickets tickets) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(tickets.stream().count())
                .append(" 개를 구매하셨습니다.")
                .append(System.lineSeparator());

        tickets.stream()
            .forEach(ticket -> {
                    stringBuilder.append(ticket)
                            .append(System.lineSeparator());
            });

        String result = stringBuilder.toString();
        System.out.println(result);
    }

    public static void printWinningResult(Map<Prize, Integer> winningResult, double rateOfReturn) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(System.lineSeparator())
                .append("당첨 통계")
                .append(System.lineSeparator())
                .append("---------");

        Arrays.stream(Prize.values())
                .filter((prize) -> !prize.equals(Prize.LOSE))
                .map((prize) -> makePrizeString(winningResult, prize))
                .forEach(stringBuilder::append);

        String result = stringBuilder.toString();
        System.out.println(result);
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", + rateOfReturn);
    }

    private static StringBuilder makePrizeString(Map<Prize, Integer> winningResult, Prize prize) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(System.lineSeparator())
                .append(prize.getCountOfMatch())
                .append(ifSecondOrNot(prize))
                .append(prize.getWinningPrize())
                .append("원)- ")
                .append(winningResult.getOrDefault(prize, 0))
                .append("개");
    }

    private static String ifSecondOrNot(Prize prize) {
        if (prize.equals(Prize.SECOND)) {
            return SECOND_WORD;
        }
        return EXCEPT_SECOND_WORD;
    }
}
