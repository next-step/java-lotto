package lotto.model;

import java.util.*;

public enum Hit {

    HIT_3(3, 5000),
    HIT_4(4, 50000),
    HIT_5(5, 1500000),
    HIT_6(6, 2000000000),
    HIT_NONE(0, 0);

    private final static String HIT_MESSAGE = "%d개 일치 (%d원)";

    private int hitCount;
    private int reward;

    Hit(int hitCount, int reward) {
        this.hitCount = hitCount;
        this.reward = reward;
    }

    public static Hit findByHitCount(int hitCount) {
        return Arrays.stream(Hit.values())
                .filter(hit -> hit.hitCount == hitCount)
                .findAny()
                .orElse(HIT_NONE);
    }

    public static Map<Hit, Integer> getHits() {
        Map<Hit, Integer> hits = new LinkedHashMap<>();

        Hit[] hitArray = Hit.values();
        Arrays.sort(hitArray);

        Arrays.stream(hitArray)
                .filter(hit -> !hit.equals(HIT_NONE))
                .forEach(hit -> hits.put(hit, 0));

        return hits;
    }

    public int calculateReword(int count) {
        return this.reward * count;
    }

    @Override
    public String toString() {
        return String.format(HIT_MESSAGE, hitCount, reward);
    }
}
