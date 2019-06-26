package lotto.domain;

public class SelfInputCount {
    private int selfInputCount;
    
    public SelfInputCount(int selfInputCount) {
        this.selfInputCount = selfInputCount;
    }
    
    public boolean canBuy(CashPayments cashPayments) {
        selfInputCount < cashPayments.getBuyableCount
        return false;
    }
}
