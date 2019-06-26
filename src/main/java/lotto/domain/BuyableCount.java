package lotto.domain;

public class BuyableCount {
    private int buyableCount;
    
    public BuyableCount(int buyableCount) {
        this.buyableCount = buyableCount;
    }
    
    public boolean isEqualsTo(int number) {
        return number == buyableCount;
    }
}
