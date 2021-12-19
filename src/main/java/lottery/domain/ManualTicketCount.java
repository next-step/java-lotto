package lottery.domain;

import java.util.Objects;

public class ManualTicketCount {

    private static final String EXCEPTION_MESSAGE_MANUAL_COUNT_EXCEEDED = "수동으로 구입하기 위한 금액이 부족합니다.";
    private static final String EXCEPTION_MESSAGE_INSUFFICIENT_MANUAL_COUNT = "수동 구매는 0장 이상 이어야 합니다.";
    private static final int MINIMUM_MANUAL_TICKET_COUNT = 0;

    private final int value;

    private ManualTicketCount(final int value) {
        this.value = value;
    }

    public static ManualTicketCount from(final int manualLotteryCount, final PurchasePrice purchasePrice) {
        if (manualLotteryCount < MINIMUM_MANUAL_TICKET_COUNT) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_INSUFFICIENT_MANUAL_COUNT);
        }

        if (manualLotteryCount > purchasePrice.affordableTicketCount()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MANUAL_COUNT_EXCEEDED);
        }

        return new ManualTicketCount(manualLotteryCount);
    }

    public AutoTicketCount autoLotteryCount(PurchasePrice purchasePrice) {
        return AutoTicketCount.from(purchasePrice.affordableTicketCount() - value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ManualTicketCount that = (ManualTicketCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}