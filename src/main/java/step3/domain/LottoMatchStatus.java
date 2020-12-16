package step3.domain;

public class LottoMatchStatus {

    private int count;
    private boolean matchBonus;

    public void increaseCount() {
        count++;
    }

    public void setMatchBonus(boolean matchBonus) {
        this.matchBonus = matchBonus;
    }

    public int getCount() {
        return count;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
