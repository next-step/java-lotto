package lotto.ui.dto;

public class LottoStatResponse {

    private final int matchCount;
    private final int matchCountResult;
    private final int receiveMoney;

    public LottoStatResponse(int matchCount, int matchCountResult, int receiveMoney) {
        this.matchCount = matchCount;
        this.matchCountResult = matchCountResult;
        this.receiveMoney = receiveMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMatchCountResult() {
        return matchCountResult;
    }

    public int getReceiveMoney() {
        return receiveMoney;
    }
}
