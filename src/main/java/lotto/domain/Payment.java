package lotto.domain;

public class Payment {

    public final static int TICKET_PRICE = 1000;
    private int totalAmount;

    public Payment(int amount) {
        validateAmount(amount);
        this.totalAmount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < TICKET_PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

    public void buyTickets(int ticketCount) {
        validateCount(ticketCount);
        this.totalAmount = pay(ticketCount * TICKET_PRICE);
    }

    private void validateCount(int ticketCount) {
        if (ticketCount < 0) {
            throw new IllegalArgumentException("구매 가능한 개수는 1개 이상 입니다.");
        }
    }

    private int pay(int some) {
        int changes = this.totalAmount - some;
        validateChanges(changes);
        return changes;
    }

    private void validateChanges(int changes) {
        if (changes < 0) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다.");
        }
    }

    public int remaining() {
        return totalAmount / TICKET_PRICE;
    }
}
