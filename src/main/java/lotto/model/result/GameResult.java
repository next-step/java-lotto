package lotto.model.result;

public class GameResult {
    private MatchingResult matchingResult;
    private EarningRate earningRate;

    public GameResult(MatchingResult matchingResult, EarningRate earningRate) {
        this.matchingResult = matchingResult;
        this.earningRate = earningRate;
    }

    public MatchingResult getMatchingResult() {
        return matchingResult;
    }

    public EarningRate getEarningRate() {
        return earningRate;
    }
}