package step2.dto;

public class JudgeResponse {
    private final int threeMatch;
    private final int fourMatch;
    private final int fiveMatch;
    private final int sixMatch;
    private final double profitIndex;

    public JudgeResponse(int threeMatch, int fourMatch, int fiveMatch, int sixMatch, double profitIndex) {
        this.threeMatch = threeMatch;
        this.fourMatch = fourMatch;
        this.fiveMatch = fiveMatch;
        this.sixMatch = sixMatch;
        this.profitIndex = profitIndex;
    }

    public int getThreeMatch() {
        return threeMatch;
    }

    public int getFourMatch() {
        return fourMatch;
    }

    public int getFiveMatch() {
        return fiveMatch;
    }

    public int getSixMatch() {
        return sixMatch;
    }

    public double getProfitIndex() {
        return profitIndex;
    }
}
