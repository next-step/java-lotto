package lotto.model;

import java.util.*;

public enum Hit {

    HIT_3(3, 5_000, "3개 일치"),
    HIT_4(4, 50_000,"4개 일치"),
    HIT_5(5, 1_500_000, "5개 일치"),
    HIT_6_BONUS(6, 30_000_000, "5개 일치, 보너스 볼 일치"),
    HIT_6(6, 2_000_000_000, "6개 일치"),
    HIT_NONE(0, 0, "NONE");

    private final static String HIT_MESSAGE = "%s (%d원)";

    private int hitCount;
    private int reward;
    private String rewardMessage;

    Hit(int hitCount, int reward, String rewardMessage) {
        this.hitCount = hitCount;
        this.reward = reward;
        this.rewardMessage = rewardMessage;
    }

    public static Hit findByNumbers(SortedSet<Integer> numbers, int bonus) {
        Hit hit = Arrays.stream(sortedValues())
                .filter(value -> value.hitCount == numbers.size())
                .findFirst()
                .orElse(HIT_NONE);

        if(hit.equals(HIT_6) && numbers.contains(bonus)){
            return HIT_6_BONUS;
        }

        return hit;
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

    private static Hit[] sortedValues() {
        Hit[] hits = Hit.values();
        Arrays.sort(hits, (x,y) -> y.reward - x.reward);
        return hits;
    }

    @Override
    public String toString() {
        return String.format(HIT_MESSAGE, rewardMessage, reward);
    }
}
