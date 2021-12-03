package lotto.dto;

import static utils.IntegerValidator.getNumberIfPositive;

import lotto.domain.Wallet;

public class AssignBuyPreTicket {

    private final Wallet wallet;
    private final int assignCount;

    public AssignBuyPreTicket(Wallet wallet, int assignCount) {
        this.wallet = wallet;
        this.assignCount = getNumberIfPositive(assignCount);
    }

    public int getAssignCount() {
        return assignCount;
    }
}
