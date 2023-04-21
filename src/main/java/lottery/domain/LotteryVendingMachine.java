package lottery.domain;

import lottery.strategy.TicketIssueStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lottery.Constant.LOTTERY_TICKET_PRICE;

public class LotteryVendingMachine {
    private static final int BALANCE_ZERO = 0;

    private final List<LotteryTicket> soldLotteryTickets;
    private final TicketIssueStrategy issueStrategy;
    private int balance;

    public LotteryVendingMachine(TicketIssueStrategy issueStrategy) {
        this.balance = BALANCE_ZERO;
        this.soldLotteryTickets = new ArrayList<>();
        this.issueStrategy = issueStrategy;
    }

    public void insertMoney(int money) {
        if (money % LOTTERY_TICKET_PRICE != 0) {
            throw new IllegalArgumentException("금액은 " + LOTTERY_TICKET_PRICE + "원 단위로 입력해주세요.");
        }
        this.balance += money;
    }

    public LotteryTicket sellTicket() {
        if (balance < LOTTERY_TICKET_PRICE) {
            throw new IllegalStateException("잔액이 부족합니다.");
        }
        this.balance -= LOTTERY_TICKET_PRICE;
        this.soldLotteryTickets.add(issueTicket());

        return this.soldLotteryTickets.get(this.soldLotteryTickets.size() - 1);
    }

    public LotteryTicket issueTicket() {
        return issueStrategy.issue();
    }

    public int getBalance() {
        return balance;
    }

    public int soldCount() {
        return soldLotteryTickets.size();
    }

    public List<LotteryTicket> sellAvailableTickets() {
        List<LotteryTicket> sellTickets = new ArrayList<>();
        while (balance >= LOTTERY_TICKET_PRICE) {
            sellTickets.add(sellTicket());
        }
        return Collections.unmodifiableList(sellTickets);
    }
}
