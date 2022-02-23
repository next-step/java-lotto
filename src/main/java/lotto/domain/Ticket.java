package lotto.domain;

public class Ticket {

    private static final String ERROR_CANNOT_BUY = "[ERROR] 최소 구매 금액은 1,000원입니다.";
    private static final String ERROR_WRONG_UNIT = "[ERROR] 로또 구매는 1,000원 단위로 가능합니다.";
    private static final String ERROR_MANUAL_OVER = "[ERROR] 입력하신 구매 금액보다 더 많은 수의 로또는 구입할 수 없습니다.";
    private static final String ERROR_NEGATIVE_NUMBER = "[ERROR] 음수는 입력할 수 없습니다.";
    private static final int ZERO = 0;
    private static final int TICKET_PRICE = 1000;

    private final int cash;
    private final int autoCount;
    private final int manualCount;

    private Ticket(int cash, int autoCount, int manualCount) {
        this.cash = cash;
        this.autoCount = autoCount;
        this.manualCount = manualCount;
    }

    public static Ticket of(int cash, int manualCount) {
        checkMoney(cash);
        int autoCount = (cash / TICKET_PRICE) - manualCount;
        checkAmount(autoCount, manualCount);
        return new Ticket(cash, autoCount, manualCount);
    }

    private static void checkMoney(int cash) {
        if (cash < TICKET_PRICE) {
            throw new IllegalArgumentException(ERROR_CANNOT_BUY);
        }

        if (cash % TICKET_PRICE > 0) {
            throw new IllegalArgumentException(ERROR_WRONG_UNIT);
        }
    }

    private static void checkAmount(int autoCount, int manualCount) {
        if (autoCount < ZERO) {
            throw new IllegalArgumentException(ERROR_MANUAL_OVER);
        }

        if (manualCount < ZERO) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
        }
    }

    public int getBuyCash() {
        return this.cash;
    }

    public int getAutoCount() {
        return this.autoCount;
    }

    public int getManualCount() {
        return this.manualCount;
    }
}
