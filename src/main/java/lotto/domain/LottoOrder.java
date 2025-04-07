package lotto.domain;

public class LottoOrder {

    public static final int PRICE_PER_TICKET = 1000;

    private final int ticketCount;

    public LottoOrder(String inputPrice) {
        int purchaseAmount = parsePrice(inputPrice);
        validateAmount(purchaseAmount);
        this.ticketCount = calculateTicketCount(purchaseAmount);
    }

    private static int parsePrice(String inputPrice) {
        try {
            return Integer.parseInt(inputPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 숫자여야 합니다.");
        }
    }

    private void validateAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    private int calculateTicketCount(int price) {
        return price / PRICE_PER_TICKET;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
