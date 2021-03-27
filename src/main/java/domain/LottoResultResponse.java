package domain;

import enums.Rank;
import java.util.List;

public class LottoResultResponse {

    private double yield;
    private List<Rank> ranks;

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
