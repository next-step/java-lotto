package lotto.domain;

public class SelfInputCount {
    private final int selfInputCount;
    
    public SelfInputCount(int selfInputCount) {
        this.selfInputCount = selfInputCount;
    }
    
    public int getSelfInputCount() {
        return selfInputCount;
    }
    
    public boolean isSame(int count) {
        return selfInputCount == count;
    }
}
