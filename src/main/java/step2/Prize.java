package step2;

import java.util.Arrays;

public class Prize {

    private final int winningCount;

    public Prize(int winningCount) {
        this.winningCount = winningCount;
    }

    public int findPrizeByWinningCount(){
        int WIN_PRIZE_THREE = 5000;
        int WIN_PRIZE_FOUR = 50000;
        int WIN_PRIZE_FIVE = 1500000;
        int WIN_PRIZE_SIX = 2000000000;

        if (winningCount == 3){
            return WIN_PRIZE_THREE;
        }
        if (winningCount == 4){
            return WIN_PRIZE_FOUR;
        }
        if (winningCount == 5){
            return WIN_PRIZE_FIVE;
        }
        if (winningCount == 6){
            return WIN_PRIZE_SIX;
        }
        return 0;
    }
}
