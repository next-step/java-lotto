package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchRecord {

    private final Map<Match, Integer> numberOfMatches;

    private MatchRecord(Map<Match, Integer> numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public static MatchRecord createRecord() {
        Map<Match, Integer> numberOfMatches = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            numberOfMatches.put(Match.from(i, false), 0);
        }

        numberOfMatches.put(Match.from(5, true), 0);

        return new MatchRecord(numberOfMatches);
    }

    public Map<Match, Integer> countMatches(List<Match> matches) {
        for (Match match : matches) {
            Integer value = numberOfMatches.get(match);
            numberOfMatches.put(match, ++value);
        }

        return numberOfMatches;
    }
}
