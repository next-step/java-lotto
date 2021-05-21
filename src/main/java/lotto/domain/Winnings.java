package lotto.domain;

public enum Winnings {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    ;
    int matched;
    int winnings;

    Winnings(int matched, int winnings) {
        this.matched = matched;
        this.winnings = winnings;
    }

    public void ifMatchedThan(int matched, Runnable runnable) {
        if(this.matched == matched){
            runnable.run();
        }
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d)");
    }
}
