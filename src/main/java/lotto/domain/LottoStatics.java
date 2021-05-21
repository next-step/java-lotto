package lotto.domain;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class LottoStatics {
    // 3개 이상부터 통계
    private static final int MIN_STATIC_RANK = 3;
    private static final int[] RANK_PRIZE = new int[] {0,0,0,5000,50000,1500000,2000000000};
    private static final String ENTER = "\n";


    private Map<Integer, Integer> rankStatics;
    private int totalGames;

    public LottoStatics() {
        init();
    }

    private void init() {
        rankStatics = new HashMap<>();
        for( int rank = MIN_STATIC_RANK; rank <= LottoGame.LOTTO_NUMBER_COUNT; rank++) {
            rankStatics.computeIfAbsent(rank,k->0);
        }
    }

    public void addStatic(int rank) {
        totalGames++;
        if (rank >= MIN_STATIC_RANK) {
            rankStatics.computeIfPresent(rank,(k,v)->v+1);
        }
    }

    public int getRankCount(int rank) {
        return rankStatics.getOrDefault(rank,0);
    }

    public Profit getProfit() {
        double total = 0;
        for (int rank : rankStatics.keySet()) {
            total += getRankCount(rank) * RANK_PRIZE[rank];
        }
        return new Profit(total,totalGames * LottoGame.PRICE);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("당첨 통계").append(ENTER)
                .append("---------").append(ENTER);
        for( int rank = MIN_STATIC_RANK; rank <= LottoGame.LOTTO_NUMBER_COUNT; rank++) {
            buffer.append(rank)
                    .append("개 일치 (")
                    .append(RANK_PRIZE[rank])
                    .append(")- ")
                    .append(rankStatics.get(rank))
                    .append("개").append(ENTER);
        }
        buffer.append("총 수익률은 ").append(getProfit().calculateRate()).append("입니다.");
        return buffer.toString();
    }
}
