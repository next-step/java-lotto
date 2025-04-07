package lotto;

public enum TicketType {
    MANUAL,
    AUTO;

    public static TicketType valueOf(boolean isManual) {
        return isManual ? MANUAL : AUTO;
    }
}
