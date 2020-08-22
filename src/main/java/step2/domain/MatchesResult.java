package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchesResult {
    Map<Integer, Long> results;

    public MatchesResult(Map<Integer, Long> results) {
        this.results = results;
    }

    public static MatchesResult ofMatchesResults(WinnersNo winnersNo, Lottos lottos) {
        return new MatchesResult(getWinningInfos(winnersNo, lottos).stream()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting())));
    }

    private static List<Integer> getWinningInfos(WinnersNo winnersNo, Lottos lottos) {
        List<Integer> winningInformation = new ArrayList<>();
        lottos.getLottos()
                .stream()
                .mapToInt(l -> hasNumber(winnersNo, l.getLotteryInfo()))
                .forEach(hitNumber -> addWinningInfos(winningInformation, hitNumber));
        return winningInformation;
    }

    private static int hasNumber(WinnersNo winnersNo, List<Integer> lotteryInfo) {
        int hitNumbers = 0;
        for (int number : winnersNo.getWinnersResultNos()) {
            hitNumbers = lotteryInfo.contains(number) ? ++hitNumbers : hitNumbers;
        }
        return hitNumbers;
    }

    private static void addWinningInfos(List<Integer> winningInformation, int hitNumber) {
        if (hitNumber > 2) {
            winningInformation.add(hitNumber);
        }
    }

    public Map<Integer, Long> getResults() {
        getBaseMap().forEach((k, v) -> results.putIfAbsent(k, v));
        return results;
    }

    private static HashMap<Integer, Long> getBaseMap() {
        return new HashMap<Integer, Long>() {{
            put(3, 0L);
            put(4, 0L);
            put(5, 0L);
            put(6, 0L);
        }};
    }
}
