package lottery.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultTest {

    @Test
    public void 당첨조회테스트() {
        Map<Integer, Integer> resultDatas = new HashMap<>();
        resultDatas.put(3, 3);
        resultDatas.put(4, 1);
        resultDatas.put(5, 0);
        resultDatas.put(51, 0);
        resultDatas.put(6, 0);
        LotteryResult lotteryResult = new LotteryResult(Arrays.asList(1,2,3,3,3,4,1,2,2,1));
        assertThat(lotteryResult.getResultDatas()).isEqualTo(resultDatas);
    }

    @Test
    public void 수익률조회테스트() {
        List<Integer> matchedDatas =  Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,3);
        LotteryResult lotteryResult = new LotteryResult(matchedDatas);
        System.out.println(lotteryResult.getResultDatas());
        assertThat(lotteryResult.getEarningRates()).isEqualTo(0.35);
    }

}