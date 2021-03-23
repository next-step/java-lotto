package lotto.dto;

import lotto.domain.Statistics;

import java.util.Map;

public class ResponseWinningDTO {
    private final Map<Statistics, Integer> hit;
    private final double yield;

    public ResponseWinningDTO(Map<Statistics, Integer> hit, double yield) {
        this.hit = hit;
        this.yield = yield;
    }

    public Map<Statistics, Integer> getHit() {
        return hit;
    }

    public double getYield() {
        return yield;
    }

}
