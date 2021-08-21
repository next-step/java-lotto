package edu.nextstep.lottobonusnumber.view;

import edu.nextstep.lottobonusnumber.domain.Prize;
import edu.nextstep.lottobonusnumber.domain.Ticket;
import edu.nextstep.lottobonusnumber.view.form.WinningResultForm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printTickets(List<Ticket> tickets) {
        System.out.println(tickets.size() + " 개를 구매하셨습니다.");
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printWinningResult(WinningResultForm winningResultForm) {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---------");

        Map<Prize, Integer> winningResult = winningResultForm.getWinningResult();
        double rateOfReturn = winningResultForm.getRateOfReturn();

        Arrays.stream(Prize.values())
                .filter((prize) -> !prize.equals(Prize.LOSE))
                .forEach((prize) -> {
                    System.out.println(prize.getCountOfMatch() + "개 일치 " +
                            "(" + prize.getWinningPrize() + "원)- " +
                            winningResult.getOrDefault(prize,0) + "개"
                    );
                });
        System.out.printf("총 수익률은 %.2f 입니다.", + rateOfReturn);
    }
}
