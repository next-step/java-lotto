package lotto.domain.lotto;

public class TicketMachine {

    private static final String INVALID_AMOUNT = "구매금액은 음수이거나 1000원 이외의 단위가 될 수 없습니댜.";
    private static final String INVALID_MANUAL_TICKETS = "수동 구매금액아 총 구매금액을 넘을 수 없습니다.";
    private static final int PRICE_PER_ONE_TICKET = 1000;
    private static final int VALIDATION_BASE_UNIT = 0;

    private final int amount;
    private final int manualTickets;
    private final int autoTickets;

    public TicketMachine(final int amount, final int manualTickets) {
        validateAmount(amount);
        validateManualTickets(amount, manualTickets);

        this.amount = amount;
        this.manualTickets = manualTickets;
        this.autoTickets = countTickets() - manualTickets;
    }

    public int amount() {
        return amount;
    }

    public int manualTickets() {
        return manualTickets;
    }

    public int autoTickets() {
        return autoTickets;
    }

    private int countTickets() {
        return amount / PRICE_PER_ONE_TICKET;
    }

    private void validateManualTickets(final int amount, final int manualTickets) {
        if (manualTickets < VALIDATION_BASE_UNIT || manualTickets * PRICE_PER_ONE_TICKET > amount) {
            throw new IllegalArgumentException(INVALID_MANUAL_TICKETS);
        }
    }

    private void validateAmount(final int amount) {
        if (amount < VALIDATION_BASE_UNIT || amount % PRICE_PER_ONE_TICKET > VALIDATION_BASE_UNIT) {
            throw new IllegalArgumentException(INVALID_AMOUNT);
        }
    }

}
