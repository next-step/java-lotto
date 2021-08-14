package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningReport {

    private Map<Rank, Integer> statistics;

    public WinningReport(List<Rank> ranks) {
        this.statistics = transformToMap(ranks);
    }

    private Map<Rank, Integer> transformToMap(List<Rank> ranks) {
        Map<Rank, Integer> result = new HashMap<>();

        for(Rank rank : Rank.values()){
            result.put(rank,0);
        }

        for(Rank rank : ranks){
            result.put(rank, result.get(rank)+1);
        }
        return result;
    }

    public Map<Rank, Integer> getStatistics() {
        return statistics;
    }
}
