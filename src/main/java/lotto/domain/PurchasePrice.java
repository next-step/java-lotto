package lotto.domain;

public class PurchasePrice {

    private final int value;

    public PurchasePrice(String inputPrice) {
        this.value = parseInt(inputPrice);
        validateAmount();
    }

    private static int parseInt(String inputPrice) {
        try {
            return Integer.parseInt(inputPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 숫자여야 합니다.");
        }
    }

    private void validateAmount() {
        if (value <= 0) {
            throw new IllegalArgumentException("구입 금액은 0원보다 커야 합니다.");
        }
    }

    public int calculateTicketCount(int ticketPrice) {
        return value / ticketPrice;
    }
}
