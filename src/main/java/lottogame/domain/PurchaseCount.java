package lottogame.domain;

import lottogame.validator.PurchaseCountValidator;

public class PurchaseCount {

    private final long count;
    private final long manualCount;

    public PurchaseCount(long count, InputLine inputLine) {
        this(count, Long.parseLong(inputLine.getLine()));
    }

    public PurchaseCount(long count, long manualCount) {
        new PurchaseCountValidator(count).validate(manualCount);
        this.count = count;
        this.manualCount = manualCount;
    }

    public long getCount() {
        return count;
    }

    public long getManualCount() {
        return manualCount;
    }

    public long getAutomaticCount() {
        return count - manualCount;
    }
}