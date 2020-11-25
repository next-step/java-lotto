package lotto.model;

import lotto.model.lotto.LottoNumber;

import java.math.BigDecimal;
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
    private long reward;
    private String rewardMessage;

    Hit(int hitCount, long reward, String rewardMessage) {
        this.hitCount = hitCount;
        this.reward = reward;
        this.rewardMessage = rewardMessage;
    }

    public static Hit findByNumbers(List<LottoNumber> matchingNumbers, LottoNumber bonus) {
        Hit hit = Arrays.stream(sortedValues())
                .filter(value -> value.hitCount == matchingNumbers.size())
                .findFirst()
                .orElse(HIT_NONE);

        if(bonusCondition(hit, matchingNumbers, bonus)){
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

    public long calculateReword(int count) {
        return this.reward * count;
    }

    private static Hit[] sortedValues() {
        Hit[] hits = Hit.values();
        Arrays.sort(hits, (x,y) -> BigDecimal.valueOf(y.reward).subtract(BigDecimal.valueOf(x.reward)).intValue());
        return hits;
    }

    private static boolean bonusCondition(Hit hit, List<LottoNumber> numbers, LottoNumber bonus){
        return hit.equals(HIT_6) && numbers.contains(bonus);
    }

    @Override
    public String toString() {
        return String.format(HIT_MESSAGE, rewardMessage, reward);
    }
}
