package lotto.view;

import lotto.domain.Amount;
import lotto.domain.LotteryNumber;
import lotto.domain.LotteryTicket;
import lotto.domain.LotteryTickets;

import java.util.List;
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
}
