package secondplacelotto.model;

import java.util.HashMap;
import java.util.Map;

public class MatchingNumbers {

    private Map<String, Integer> matchingCountByRank = new HashMap<String, Integer>(){
        {
            put("1", 0);
            put("2", 0);
            put("3", 0);
            put("4", 0);
            put("5", 0);
        }
    };

    public void addMatchingCount(String rank) {
        matchingCountByRank.put(rank, matchingCountByRank.get(rank) + 1);
    }

    public int getMatchingCount(String rank) {
        return matchingCountByRank.get(rank);
    }

    public int getMatchingNumbersCount() {
        return matchingCountByRank.size();
    }


}
