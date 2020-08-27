package step2.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static step2.domain.BaseScore.getBaseMap;

public class MatchesResult {
    private Map<ScoreType, Long> results;

    public MatchesResult(Map<ScoreType, Long> results) {
        this.results = results;
    }

    public static MatchesResult ofMatchesResults(WinnersNo winnersNo, Lottos lottos) {
        return new MatchesResult(lottos.getWinningInfos(winnersNo)
                                       .stream()
                                       .filter(info -> ScoreType.NONE != info)
                                       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    public static LinkedHashMap<ScoreType, Long> sortMapByKey(Map<ScoreType, Long> map) {
        List<Map.Entry<ScoreType, Long>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, Comparator.comparing(Map.Entry::getKey));
        return entries
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
    }

    public Map<ScoreType, Long> getResults() {
        getBaseMap().forEach((k, v) -> results.putIfAbsent(k, v));
        return sortMapByKey(results);
    }
}
