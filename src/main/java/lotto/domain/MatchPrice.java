package lotto.domain;

public class MatchPrice {

    private int matchPrice;

    public MatchPrice() {
        this.matchPrice = 0;
    }

    public int getMatchPrice() {
        return matchPrice;
    }

    public void matching(int matchPrice) {
        this.matchPrice = matchPrice;
    }
}
