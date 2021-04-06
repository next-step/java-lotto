package domain;

import enums.Rank;
import java.util.List;

public class LottoResultResponse {

    private final double yield;
    private final List<Rank> ranks;

    public LottoResultResponse(double yield, List<Rank> ranks) {
        this.yield = yield;
        this.ranks = ranks;
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public double getYield() {
        return yield;
    }
}
