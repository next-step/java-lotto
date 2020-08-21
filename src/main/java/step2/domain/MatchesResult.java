package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchesResult {
    Map<Integer, Long> results;

    public MatchesResult(Map<Integer, Long> results) {
        this.results = results;
    }

    public static MatchesResult ofMatchesResults(List<WinningInformation> winningInformation) {
        return new MatchesResult(winningInformation.stream()
                .collect(Collectors.groupingBy(WinningInformation::getNumberOfMatches, Collectors.counting())));
    }

    private static HashMap<Integer, Long> getBaseMap() {
        return new HashMap<Integer, Long>() {{
            put(3, 0L);
            put(4, 0L);
            put(5, 0L);
            put(6, 0L);
        }};
    }

    public Map<Integer, Long> getResults() {
        getBaseMap().forEach((k, v) -> results.putIfAbsent(k, v));
        return results;
    }
}
