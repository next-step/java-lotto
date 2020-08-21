package step2.domain;

public class WinningInformation {
    private int round;
    private int numberOfMatches;

    public WinningInformation(int round, int numberOfMatches) {
        this.round = round;
        this.numberOfMatches = numberOfMatches;
    }

    public int getRound() {
        return round;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }
}
