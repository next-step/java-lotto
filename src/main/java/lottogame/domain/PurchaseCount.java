package lottogame.domain;

import lottogame.validator.PurchaseCountValidator;

public class PurchaseCount {

    private long count;
    private long manualCount;

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