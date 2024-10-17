package lotto;

public class WinningRule {

    private final int match;
    private final int reward;

    public WinningRule(int match, int reward) {
        this.match = match;
        this.reward = reward;
    }

    public int getMatch() {
        return this.match;
    }

    public int getReward() {
        return this.reward;
    }
}
