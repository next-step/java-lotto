package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;

public enum LottoRank {
    FOUR(3, 5000, false, 3),
    TRHEE(4, 50000, false, 4),
    TWO(5, 1500000, false, 5),
    TWO_BONUS(5, 30000000, true, 7),
    ONE(6, 2000000000, false, 6);

    private final int matchingCount;
    private final int reward;
    private final int keyNumber;
    private final boolean bonus;

    LottoRank(int matchingCount, int reward, boolean bonus, int keyNumber) {
        this.matchingCount = matchingCount;
        this.reward = reward;
        this.bonus = bonus;
        this.keyNumber = keyNumber;
    }

    public int getMatchingCount() {
        return this.matchingCount;
    }

    public int getReward() {
        return this.reward;
    }

    public int getKeyNumber() {
        return this.keyNumber;
    }

    public Boolean getBonus() {
        return this.bonus;
    }

    public static int lottoRankValue(int checkData) {
        HashMap<Integer, LottoRank> lottoRankMap = new HashMap<>();

        Arrays.stream(values()).forEach(e -> lottoRankMap.put(e.getKeyNumber(), e));
        return lottoRankMap.get(checkData).getReward();
    }
}
