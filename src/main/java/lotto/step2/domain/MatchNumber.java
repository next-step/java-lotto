package lotto.step2.domain;

public enum MatchNumber {
    THREE(0), FOUR(1), FIVE(2), SIX(3);
    
    private final int index;
    
    MatchNumber(int index) {
        this.index = index;
    }
    
    
    public boolean isSame(int index) {
        return this.index == index;
    }
}
