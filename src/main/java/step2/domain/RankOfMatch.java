package step2.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class RankOfMatch {

    private final List<Integer> matchResult;

    public RankOfMatch(List<Integer> matchResult) {
        this.matchResult = matchResult;
    }

    public Map<Integer, List<Rank>> groupMatchOfLotto(Iterator<Boolean> matchOfBonus) {
        Map<Integer, List<Rank>> statisticsOfRank = matchResult.stream()
                .map(countOfMatch -> Rank.valueOf(countOfMatch, matchOfBonus.next()))
                .collect(groupingBy(Rank::getWinningMoney));

        Rank[] values = Rank.values();
        for (int i = 0; i < Rank.values().length; i++) {
            inputEmptyList(statisticsOfRank, values[i].getWinningMoney());
        }
        return statisticsOfRank;
    }

    private void inputEmptyList(Map<Integer, List<Rank>> collect, int winningMoney) {
        if (!collect.containsKey(winningMoney)) {
            collect.put(winningMoney, new ArrayList<>());
        }
    }
}
