package step2.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Money {
    private final int amount;

    public Money(int amount) {
        if (!valid(amount)) {
            Logger logger = Logger.getGlobal();
            logger.log(Level.SEVERE, "negative money is not allowed");
            throw new IllegalArgumentException("negative money is not allowed");
        }
        this.amount = amount;
    }

    public final int getAmount() {
        return amount;
    }

    private boolean valid(int amount) {
        return amount >= 0;
    }

}
