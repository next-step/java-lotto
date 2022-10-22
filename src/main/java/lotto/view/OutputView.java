package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public void printAmount(Amount amount) {
        System.out.printf("%d개를 구매했습니다.%n", amount.getAmount());
    }

    public void printTickets(LotteryTickets tickets) {
        for(LotteryTicket ticket : tickets.getLotteryTickets()) {
            printTicket(ticket);
        }
    }

    private void printTicket(LotteryTicket ticket) {
        List<String> numbers = ticket.getLotteryNumbers()
                .stream()
                .map(LotteryNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.printf("[%s]%n", String.join(", ", numbers));
    }

    public void printResult(Ranks ranks, Double prize) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for(var rank : ranks.getRanks().entrySet()) {
            printRank(rank.getKey(), rank.getValue());
        }
        System.out.println();
        System.out.printf("총 수익률은 %.2f입니다.", prize);
    }

    private void printRank(Rank rank, Integer count) {
        if(rank != Rank.NON_MATCH) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", rank.getCount(), rank.getPrize(), count);
        }
    }
}
