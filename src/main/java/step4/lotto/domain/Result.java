package step4.lotto.domain;

import java.util.*;

public class Result {
    private Map<Rank, Count> result;

    public Result() {
        result = new HashMap<>();
        init();
    }

    public void init() {
        for (Rank rank : Rank.values()) {
            result.put(rank, new Count());
        }
    }

    public void plusRankCount(Rank rank) {
        result.get(rank).plus();
    }

    public Count getRankCount(Rank rank) {
        return result.get(rank);
    }


    public String displayResult() {
        String text = "";
        TreeMap<Rank, Count> treeMap = new TreeMap<>(result);
        for (Rank rank : treeMap.descendingKeySet()) {
            text += makeText(rank);
        }
        return text;
    }
    public int prize() {
        int total = 0;
        TreeMap<Rank, Count> treeMap = new TreeMap<>(result);
        for (Rank rank : treeMap.descendingKeySet()) {
            total += ( rank.getWinigMoney() * result.get(rank).getCount());
        }
        return total;


    }

    private String makeText(Rank rank) {
        if(rank == Rank.MISS){
            return "";
        }
        return rank.getMatchCount() +"개 일치 (" + rank.getWinigMoney() +")-" + result.get(rank).getCount() +"개\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result that = (Result) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

}
