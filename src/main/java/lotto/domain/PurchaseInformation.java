package lotto.domain;

public class PurchaseInformation {
    public static final String NOT_VALID_COUNT_ERROR_MESSAGE = "수동 로또 개수가 전체 로또 개수보다 클 수 없습니다.";
    private final int price;
    private final int manualCount;

    public PurchaseInformation(int price, int manualCount) {
        this.price = price;
        this.manualCount = manualCount;
        validateCount(manualCount);
    }

    private void validateCount(int manualCount) {
        if (manualCount > totalCount()) {
            throw new IllegalArgumentException(NOT_VALID_COUNT_ERROR_MESSAGE);
        }
    }

    public int totalCount() {
        return price / 1000;
    }

    public int autoCount() {
        return totalCount() - this.manualCount;
    }

    public int manualCount() {
        return this.manualCount;
    }
}
