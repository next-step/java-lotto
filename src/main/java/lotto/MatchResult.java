package lotto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchResult {
    // TODO : Check enum is useful
    // TODO : change PRIZE_REWARDS to arraylist
    private static final int[] PRIZE_REWARDS = {
        5000, 50_000, 1_500_000, 30_000_000, 2_000_000_000
    };

    private int tryCount;
    private List<Integer> prizeCount;
    public MatchResult() {
        tryCount = 0;
        prizeCount = Arrays.asList(new Integer[]{0,0,0,0,0});
    }

    // prizeCount의 input 등수의 카운 올림
    public void countUpMatch (int input) {
        // 0 개 맞췄을 때 -1, 임1개 맞추면 prizeCount의 꼴찌(6등) 카운트가 올라
        if(input-1>=0){
            prizeCount.set(input, prizeCount.get(input) + 1);
        }
    }

    public MatchResult(int tryCount, List<Integer> prizeCount) {
        this.tryCount = tryCount;
        this.prizeCount = prizeCount;
    }

//    TODO:
    public List<Integer> getResult() {
        return prizeCount;
    }

    public double CalculateWinningRevenue() {
        int rewards = 0;
        for (int i = 0; i < 5; i++) {
            rewards += prizeCount.get(i) * PRIZE_REWARDS[i];
        }
        return rewards / (tryCount * 1000);
    }
}
