package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public enum Division {
    FIFTH(Arrays.asList(3), false, 5_000),
    FOURTH(Arrays.asList(4), false, 50_000),
    THIRD(Arrays.asList(5), false, 1_500_000),
    SECOND(Arrays.asList(5), true, 30_000_000),
    FIRST(Arrays.asList(6), false, 2_000_000_000),
    LOSE(Arrays.asList(0, 1, 2), false, 0);

    public final static Map<Division, Integer> rankCounts = new EnumMap<>(Division.class);

    static {
        rankCounts.put(Division.FIFTH, 0);
        rankCounts.put(Division.FOURTH, 0);
        rankCounts.put(Division.THIRD, 0);
        rankCounts.put(Division.SECOND, 0);
        rankCounts.put(Division.FIRST, 0);
    }

    private List<Integer> matchCounts;
    private boolean matchBonus;
    private int prize;

    private Division(List<Integer> matchCounts, boolean matchBonus, int prize) {
        this.matchCounts = matchCounts;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Division valueOf(int matchCount) {
        return Division.valueOf(matchCount, false);
    }

    public static Division valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(division -> division.matchCounts.contains(matchCount))
                .filter(division -> {
                    if (division.matchCounts.contains(5)) {
                        return division.matchBonus == matchBonus;
                    }
                    return true;
                })
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("로또 맞은 번호의 개수가 지정된 범위를 벗어납니다."));
    }

    public final static Map<Division, Integer> getRankCounts() {
        return rankCounts;
    }
}
