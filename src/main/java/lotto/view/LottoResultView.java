package lotto.view;

import lotto.Result;
import lotto.domain.Ticket;
import lotto.enums.Rank;

import java.util.Map;

public class LottoResultView {
    public static void printTicket(Ticket ticket) {
        System.out.println(ticket);
    }

    public static void printResult(Result result) {
        System.out.println("당첨결과\n================================");
        for (Map.Entry<Rank, Integer> entry : result.getWinningCountPerRank().entrySet()) {
            System.out.printf("%s : %d개 일치(%d원) - %d개%n",
                    entry.getKey().toString(), entry.getKey().getMatchCount(), entry.getKey().getPrizeAmount(), entry.getValue()
            );
        }
        System.out.printf("총 수익률은 %.2f 입니다.%n", result.getRateOfReturn());
    }
}
