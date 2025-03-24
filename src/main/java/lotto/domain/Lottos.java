package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getSize() {
        return lottos.size();
    }

    public Map<Integer, Integer> getMatchNums(Lotto winningNumbers) {
        Map<Integer, Integer> matchNums = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchNum = lotto.getMatchNum(winningNumbers);
            matchNums.put(matchNum, matchNums.getOrDefault(matchNum, 0) + 1);
        }
        return matchNums;
    }
}
