package domain;

import enums.Rank;
import java.util.List;

public class LottoResultResponse {

    private double yield;
    private List<Rank> ranks;
    private LottoNumber bonusNumber;

    public LottoResultResponse(double yield, List<Rank> ranks, LottoNumber bonusNumber) {
        this.yield = yield;
        this.ranks = ranks;
        this.bonusNumber = bonusNumber;
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public double getYield() {
        return yield;
    }
}
