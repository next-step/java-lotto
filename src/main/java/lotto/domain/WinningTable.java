package lotto.domain;

import lotto.context.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningTable {
    private final static Integer ADD_AUTO_INCREMENT = 1;
    private final static Integer MIN_MATCH_COUNT = 3;

    private final Map<Rank, Integer> matchCountTable;

    public WinningTable() {
        matchCountTable = new LinkedHashMap<>();
        setDefaultData();
    }

    private void setDefaultData() {
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .forEach(this::putDefaultData);
    }

    private void putDefaultData(Rank rank) {
        if (matchCountTable.containsKey(rank)) {
            return;
        }
        matchCountTable.put(rank, 0);
    }

    public Map<Rank, Integer> getMatchCountTable() {
        return matchCountTable;
    }

    public void setAutoIncrementMatchCountResult(Integer matchCount) {
        if (matchCount < MIN_MATCH_COUNT) {
            return;
        }
        matchCountTable.put(Rank.getRank(matchCount), matchCountTable.get(Rank.getRank(matchCount)) + ADD_AUTO_INCREMENT);
    }

    Integer getTotalWinningMoney() {
        return matchCountTable.entrySet()
                .stream()
                .map(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .reduce(Integer::sum)
                .get();
    }
}
