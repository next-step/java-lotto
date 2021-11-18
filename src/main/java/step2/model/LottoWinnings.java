package step2.model;

import java.util.Map;

public class LottoWinnings {

    private static final int THREE_MATCH_WINNINGS = 5000;
    private static final int FOUR_MATCH_WINNINGS = 50000;
    private static final int FIVE_MATCH_WINNINGS = 1500000;
    private static final int SIX_MATCH_WINNINGS = 2000000000;

    public static int getYield(Map<Integer, Integer> winners) {
        return 5000;
    }
    
}
