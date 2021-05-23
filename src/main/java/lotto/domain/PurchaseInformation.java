package lotto.domain;

import static lotto.domain.LottoTicket.MINIMUM_PRICE;

public class PurchaseInformation {
    public static final String NOT_VALID_COUNT_ERROR_MESSAGE = "수동 로또 개수가 전체 로또 개수보다 클 수 없습니다.";
    public static final String TICKET_PRICE_ERROR_MESSAGE = "티켓값은 최소 1000원 이상이어야 합니다.";

    private final int price;
    private final int manualCount;

    public PurchaseInformation(int price, int manualCount) {
        this.price = price;
        this.manualCount = manualCount;
        validatePrice(price);
        validateCount(manualCount);
    }

    public int totalCount() {
        return price / MINIMUM_PRICE;
    }

    public int autoCount() {
        return totalCount() - this.manualCount;
    }

    public int manualCount() {
        return this.manualCount;
    }

    public int getPrice() {
        return price;
    }

    private void validatePrice(int price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException(TICKET_PRICE_ERROR_MESSAGE);
        }
    }

    private void validateCount(int manualCount) {
        if (manualCount > totalCount()) {
            throw new IllegalArgumentException(NOT_VALID_COUNT_ERROR_MESSAGE);
        }
    }
}
