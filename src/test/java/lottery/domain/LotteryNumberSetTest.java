package lottery.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryNumberSetTest {

    private  LotteryNumberSet lotteryNumberSet;
    
    @Test
    public void 숫자세팅테스트() {
        lotteryNumberSet = new LotteryNumberSet();
        int result = lotteryNumberSet.getLotteryNumbers().size();
        assertThat(result).isEqualTo(45);
    }

    @Test
    public void 자동값테스트() {
        lotteryNumberSet = new LotteryNumberSet() {
            @Override
            List<Integer> suffle(List<Integer> lotteryNumbers) {
                return Arrays.asList(1,2,3,4,5,6);
            }
        };
        List<Integer> result = lotteryNumberSet.extractRandomNumbers();
        assertThat(result).isEqualTo(Arrays.asList(1,2,3,4,5,6));
        
    }


}