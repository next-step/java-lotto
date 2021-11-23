package step2.view;

import java.util.Map;

public class LottoResultDto {

    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;

    private int threeMatchCount;
    private int fourMatchCount;
    private int fiveMatchCount;
    private int sixMatchCount;
    private double yield;

    public LottoResultDto(Map<Integer, Integer> winnersMap, double yield) {
        threeMatchCount = winnersMap.get(THREE_MATCH);
        fourMatchCount = winnersMap.get(FOUR_MATCH);
        fiveMatchCount = winnersMap.get(FIVE_MATCH);
        sixMatchCount = winnersMap.get(SIX_MATCH);
        this.yield = yield;
    }

    public int getThreeMatchCount() {
        return threeMatchCount;
    }

    public int getFourMatchCount() {
        return fourMatchCount;
    }

    public int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public int getSixMatchCount() {
        return sixMatchCount;
    }

    public double getYield() {
        return yield;
    }
}
