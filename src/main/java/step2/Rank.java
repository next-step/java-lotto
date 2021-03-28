package step2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rank {

    private static final int INIT_VALUE = 0;
    private Map<LottoPrize, Integer> rank;

    public Rank(){
        initRankMap();
    }

    private void initRankMap() {
        rank = new HashMap<>();
        rank.put(LottoPrize.BLANK , INIT_VALUE);
        rank.put(LottoPrize.FIRST , INIT_VALUE);
        rank.put(LottoPrize.SECOND , INIT_VALUE);
        rank.put(LottoPrize.THIRD , INIT_VALUE);
        rank.put(LottoPrize.FOURTH , INIT_VALUE);
        rank.put(LottoPrize.FIFTH , INIT_VALUE);
    }

    public Map<LottoPrize, Integer> rank(List<LottoStatistic> lottoStatistics) {
        for(LottoStatistic statistic : lottoStatistics){
            rank.computeIfPresent(statistic.lottoPrize(),(a , b)-> b + 1);
        }
        return rank;
    }
}
