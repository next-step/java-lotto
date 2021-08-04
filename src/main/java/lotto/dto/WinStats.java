package lotto.dto;

import lotto.domain.WinAmount;

import java.util.Map;

public class WinStats {

    private Map<WinAmount, Integer> matchMap;
    private float yield;

    public WinStats(Map<WinAmount, Integer> matchMap, float yield) {
        this.matchMap = matchMap;
        this.yield = yield;
    }

    public float getYield() {
        return yield;
    }

    public Map<WinAmount, Integer> getMatchMap() {
        return matchMap;
    }

    @Override
    public String toString() {
        return "{\n" +
                "    matchMap : " + matchMap + "\n" +
                "    yield : " + yield + "\n" +
                "}";
    }
}
