package lottery.domain;

import lottery.strategy.TicketIssueStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottery.domain.LotteryTicket.LOTTERY_TICKET_PRICE;

public class LotteryVendingMachine {
    public LotteryVendingMachine() {
    }

    public LotteryTicket issueTicket(TicketIssueStrategy issueStrategy) {
        return issueStrategy.issue();
    }

    public List<LotteryTicket> sellTickets(int money, TicketIssueStrategy issueStrategy) {
        int ticketCount = calculateNumberOfTickets(money);
        return issueTickets(ticketCount, issueStrategy);
    }

    public int calculateNumberOfTickets(int money) {
        if (!isValidMoney(money)) {
            throw new IllegalArgumentException("금액은 " + LOTTERY_TICKET_PRICE + "원 단위로 입력해주세요.");
        }
        return money / LOTTERY_TICKET_PRICE;
    }

    private boolean isValidMoney(int money) {
        return money % LOTTERY_TICKET_PRICE == 0;
    }

    private List<LotteryTicket> issueTickets(int ticketCount, TicketIssueStrategy issueStrategy) {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> issueTicket(issueStrategy))
                .collect(Collectors.toList());
    }
}
