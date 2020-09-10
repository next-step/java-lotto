package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Prize {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    ETC(0, false, 0);

    private static final Map<Boolean, Map<Long, Prize>> BY_BONUS = new HashMap<>();

    static {
        BY_BONUS.put(true, prizeByBonus(true));
        BY_BONUS.put(false, prizeByBonus(false));
    }

    private final long matchCount;
    private final boolean matchBonus;
    private final int reward;

    private Prize(long matchCount, boolean matchBonus, int reward) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.reward = reward;
    }

    private static Map<Long, Prize> prizeByBonus(boolean matchBonus) {
        List<Prize> prizes = Arrays.stream(values())
                .filter(prize -> prize.matchBonus == matchBonus)
                .collect(Collectors.toList());
        return prizeByMatchCount(prizes);
    }

    private static Map<Long, Prize> prizeByMatchCount(List<Prize> prizes) {
        Map<Long, Prize> byMatchCount = new HashMap<>();
        for (Prize prize : prizes) {
            byMatchCount.put(prize.matchCount, prize);
        }
        return byMatchCount;
    }

    public static Prize valueOfMatchCount(Long matchCount, boolean matchBonus) {
        // 보너스 여부에 따라 서로 다른 Map에서 가져온다.
        if (byBonus(matchBonus).containsKey(matchCount)) {
            return byBonus(matchBonus).get(matchCount);
        }
        // 위에서 성공적으로 가져오지 못했다면 나머지 Map에서 가져온다.
        return byBonus(!matchBonus).getOrDefault(matchCount, Prize.ETC);
    }

    private static Map<Long, Prize> byBonus(boolean matchBonus) {
        return BY_BONUS.get(matchBonus);
    }

    public static List<Prize> valuesOfWin() {
        return Arrays.asList(Prize.FIFTH, Prize.FOURTH, Prize.THIRD, Prize.SECOND, Prize.FIRST);
    }

    public long getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
