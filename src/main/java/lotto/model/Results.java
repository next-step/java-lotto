package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private static Map<Rank, Integer> results = new HashMap<>();

    static {
        for(Rank rank:Rank.values()){
            results.put(rank, 0);
        }
    }

    public static Results reflectAll(List<Rank> ranks) {
        return null;
    }

    public int getCount(Rank rank){
        return results.get(rank);
    }
}
