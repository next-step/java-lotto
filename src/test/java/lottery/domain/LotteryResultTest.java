package lottery.domain;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultTest {

    @Test
    public void 당첨조회테스트() {
        Map<RANK, Integer> resultDatas = new HashMap<>();
        resultDatas.put(RANK.FIFTH, 3);
        resultDatas.put(RANK.FOURTH, 1);
        resultDatas.put(RANK.THIRD, 0);
        resultDatas.put(RANK.SECOND, 0);
        resultDatas.put(RANK.FIRST, 0);
        resultDatas.put(RANK.MISS, 2);
        LotteryResult lotteryResult = new LotteryResult(Arrays.asList(RANK.FIFTH,RANK.FIFTH,RANK.FIFTH,RANK.FOURTH,RANK.MISS,RANK.MISS));
        assertThat(lotteryResult.getResultDatas()).isEqualTo(resultDatas);
    }

    @Test
    public void 수익률조회테스트() {
        List<RANK> matchedDatas = new ArrayList<>();
        for (int index = 0; index < 13; index++) {
            matchedDatas.add(RANK.MISS);
        }
        matchedDatas.add(RANK.FIFTH);
        LotteryResult lotteryResult = new LotteryResult(matchedDatas);
        System.out.println(lotteryResult.getResultDatas());
        assertThat(lotteryResult.getEarningRates()).isEqualTo(0.35);
    }

}