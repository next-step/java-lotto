package lotto.dto;

import lotto.domain.LottoNumbers;
import lotto.domain.Money;

import java.util.List;

public class OrderRequest {

    private final int amount;

    private final List<LottoNumbers> tickets;

    public OrderRequest(int amount, List<LottoNumbers> tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }

    public static OrderRequest from(Money money, List<LottoNumbers> tickets) {
        verify(tickets.size(), money);
        return new OrderRequest(calculateAutoCounts(tickets.size(), money), tickets);
    }

    public int getAmount() {
        return amount;
    }

    public List<LottoNumbers> getTickets() {
        return tickets;
    }

    private static int calculateAutoCounts(int manualCounts, Money money) {
        Money remain = money.subtract(LottoNumbers.PRICE.multiply(manualCounts));
        return remain.divideBy(LottoNumbers.PRICE);
    }

    private static void verify(int count, Money money) {
        if (LottoNumbers.PRICE.multiply(count).compareTo(money) > 0) {
            throw new IllegalArgumentException("예산을 초과하여 구매할 수 없습니다.");
        }
    }
}
