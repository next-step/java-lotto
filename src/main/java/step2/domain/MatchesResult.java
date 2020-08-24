package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

import static step2.domain.BaseScore.getBaseMap;

public class MatchesResult {
    Map<ScoreType, Long> results;

    public MatchesResult(Map<ScoreType, Long> results) {
        this.results = results;
    }

    public static MatchesResult ofMatchesResults(WinnersNo winnersNo, Lottos lottos) {
        return new MatchesResult(getWinningInfos(winnersNo, lottos)
                .stream()
                .collect(Collectors.groupingBy(Scores::getScore, Collectors.counting())));
    }

    private static List<Scores> getWinningInfos(WinnersNo winnersNo, Lottos lottos) {
        List<Scores> winningInformation = new ArrayList<>();
        for (Lotto l : lottos.getLottos()) {
            int hitNumber = hasNumber(winnersNo, l.getLotteryInfo());
            addWinningInfos(winningInformation, hitNumber, hasBonusNumber(hitNumber, winnersNo.getBonusNumber(), l.getLotteryInfo()));
        }
        return winningInformation;
    }

    private static int hasNumber(WinnersNo winnersNo, List<Integer> lotteryInfo) {
        int hitNumbers = 0;
        for (int number : winnersNo.getWinnersResultNos()) {
            hitNumbers = lotteryInfo.contains(number) ? ++hitNumbers : hitNumbers;
        }
        return hitNumbers;
    }

    private static boolean hasBonusNumber(int hitNumbers, int BonusNumber, List<Integer> lotteryInfo) {
        return hitNumbers == 5 && lotteryInfo.contains(BonusNumber);
    }

    private static void addWinningInfos(List<Scores> winningInformation, int hitNumber, boolean hasBonusNumber) {
        if (hitNumber > 2) {
            winningInformation.add(new Scores(hitNumber, hasBonusNumber));
        }
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
