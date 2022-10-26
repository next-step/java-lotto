package step4.dto;

import step4.domain.Ticket;

public class TicketDTO {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private final int purchasePrice;
    private final int countOfAutoTicket;
    private final int countOfManualTicket;

    public TicketDTO(int purchasePrice, int countOfAutoTicket, int countOfManualTicket) {
        validatePrice(purchasePrice);
        validateTicketCount(countOfAutoTicket, countOfManualTicket);
        this.purchasePrice = purchasePrice;
        this.countOfAutoTicket = countOfAutoTicket;
        this.countOfManualTicket = countOfManualTicket;
    }

    public static TicketDTO of(final int purchasePrice, final int countOfManualTicket) {
        final int allTicket = purchasePrice / LOTTO_TICKET_PRICE;
        final int autoTicket = allTicket - countOfManualTicket;
        return new TicketDTO(purchasePrice, autoTicket, countOfManualTicket);
    }

    private void validatePrice(final int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("구입금액은 양수여야 합니다.");
        }

        if (price % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException("로또티켓은 한 장 당 1000원입니다.");
        }
    }

    private void validateTicketCount(int countOfAutoTicket, int countOfManualTicket) {
        if (countOfAutoTicket < 0) {
            throw new IllegalArgumentException("총 구매 금액 이상으로 수동 로또를 구매할 수 없습니다");
        }
    }

    public Ticket toManualTicket() {
        return Ticket.from(this.countOfManualTicket);
    }

    public Ticket toAutoTicket() {
        return Ticket.from(this.countOfAutoTicket);
    }

    public int getCountOfAutoTicket() {
        return countOfAutoTicket;
    }

    public int getCountOfManualTicket() {
        return countOfManualTicket;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
