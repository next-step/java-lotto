package lotto.dto;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private HashMap<Rank, Integer> rankCounts;

    public Result() {
        this.rankCounts = new HashMap<Rank, Integer>();
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    public void put(Rank rank){
        rankCounts.merge(rank, 1, Integer::sum);
    }
}
