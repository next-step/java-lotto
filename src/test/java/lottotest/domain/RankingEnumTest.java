package lottotest.domain;

import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RankingEnumTest {

    private LottoRank rankingtest;

    @Test
    @DisplayName(value = "랭킹출력")
    void printrank() {
        System.out.println(rankingtest.findRank(6, false));
        System.out.println(rankingtest.findRank(5, true));
    }

    @Test
    @DisplayName(value = "전체출력")
    void print() {

        for (LottoRank rankingtest : rankingtest.values()) {
            System.out.println(rankingtest.toString());

            //System.out.println( String.format("키 -> %s, 값 -> %s", result.LottoRank, Integer) );
        }

    }

    @Test
    @DisplayName(value = "전체출력")
    void printResult() {
        Map<LottoRank, Integer> result = new HashMap<>();

        for (LottoRank rankingtest : rankingtest.values()) {
            result.put(rankingtest, 1);
        }

        System.out.println(result.toString());
        //result.put(FIRST, 1);
        //System.out.println(result.toString());

        result.forEach((key, value)->{
            System.out.println( String.format("키 -> %d, 값 -> %s", key.getReward(), value) );
        });
    }


    @Test
    public void calculateRate(){

        Map<LottoRank, Integer> result = new HashMap<>();

        for (LottoRank rankingtest : rankingtest.values()) {
            result.put(rankingtest, 1);
        }

        AtomicInteger sum = new AtomicInteger();

        //Set<LottoRank> lottoRanks = result.keySet();

        /*for (LottoRank lottoRank : lottoRanks) {
            int hitCount = ranks.get(lottoRank);
            int rewarding = lottoRank.getRewarding();
            sum += rewarding * hitCount;
        }*/

        result.forEach((key, value)->{
            //System.out.println( String.format("키 -> %s, 값 -> %s", key, value) );
            System.out.println( String.format(" %s - %s개", key, value) );
            sum.set(sum.get() + key.getReward() * value);
        });

        //BigDecimal totalRewarding = new BigDecimal(sum);
        //sum =
        //return totalRewarding.divide(price, 2, RoundingMode.DOWN);
        System.out.println ("수익은 " + sum.get());

        double rate =  sum.get() /16000 * 100;

        System.out.println ("총 수익률은 " + rate); //총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
    }

}
