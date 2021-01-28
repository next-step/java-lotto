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
    private static final int MIN_MATCH_BOUND = 3;
    private static final int BONUS_REWARD_IDX = 3;
    private static final int MAX_MATCH_IDX = 5;

    private Integer tryCount;
    private List<Integer> prizeCount;
    public MatchResult(Integer tryCount) {
        this.tryCount = tryCount;
        prizeCount = Arrays.asList(new Integer[]{0,0,0,0,0});
    }

    // prizeCount의 input 등수의 카운 올림
    public void countUpMatch (Lotto lotto,List<LottoTicket> tickets) {
        // 0 개 맞췄을 때 -1, 임1개 맞추면 prizeCount의 꼴찌(6등) 카운트가 올라
        for(LottoTicket ticket : tickets) {
            matchOneTicket(lotto, ticket);
        }
    }
    private void matchOneTicket (Lotto lotto,LottoTicket ticket) {
        int matchCount = lotto.matchLotto(ticket);
        // TODO : Enum 적용!!
        // 6개
        if(matchCount==6){
            prizeCount.set(MAX_MATCH_IDX, prizeCount.get(MAX_MATCH_IDX) + 1);
            return;
        }
        if(matchCount==5 && lotto.matchBonus(ticket)){
            prizeCount.set(BONUS_REWARD_IDX, prizeCount.get(BONUS_REWARD_IDX) + 1);
            return;
        }
        // 3~4개일 떄 & 5개 이고 보너스 x
        if(matchCount>=MIN_MATCH_BOUND) {
            prizeCount.set(matchCount-MIN_MATCH_BOUND, prizeCount.get(matchCount-MIN_MATCH_BOUND) + 1);
            return;
        }
    }

    public MatchResult(int tryCount, List<Integer> prizeCount) {
        this.tryCount = tryCount;
        this.prizeCount = prizeCount;
    }

    //    TODO :
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
