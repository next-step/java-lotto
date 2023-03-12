package lotto.service;

import java.util.Arrays;
import java.util.HashMap;

public enum LottoRank {
    THREE(3, 5000, false, 3),
    FOUR(4, 50000, false, 4),
    FIVE(5, 1500000, false, 5),
    FIVE_BONUS(5, 30000000, true, 7),
    SIX(6, 2000000000, false, 6);

    private final int matchingCount;
    private final int reward;
    private final int keyNumber;
    private final boolean bonus;
    private static HashMap<Integer, LottoRank> lottoRankMap = new HashMap<>();

    LottoRank(int matchingCount, int reward, boolean bonus, int keyNumber){
        this.matchingCount = matchingCount;
        this.reward = reward;
        this.bonus = bonus;
        this.keyNumber = keyNumber;
    }

    public int getMatchingCount(){
        return this.matchingCount;
    }

    public int getReward(){
        return this.reward;
    }

    public int getKeyNumber() { return this.keyNumber; }

    public Boolean getBonus(){
        return this.bonus;
    }

    public static int lottoRankValue(int checkData){
        Arrays.stream(values()).forEach(e -> lottoRankMap.put(e.getKeyNumber(), e));
        return lottoRankMap.get(checkData).getReward();
    }
}
