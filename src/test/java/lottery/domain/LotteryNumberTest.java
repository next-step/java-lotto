package lottery.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryNumberTest {

    @Test
    public void 자동값테스트() {
        LotteryNumber number = new LotteryNumber() {
            @Override
            List<Integer> suffle(List<Integer> lotteryNumbers) {
                return Arrays.asList(1,2,3,4,5,6);
            }
        };
        List<Integer> result = number.extractRandomNumbers();
        assertThat(result).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호_입력_테스트() {
        new LotteryNumber(Arrays.asList(1,2,3,4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스번호_입력_테스트() {
        new LotteryNumber(Arrays.asList(1,2,3,4,5,6),6);
    }

    @Test
    public void 보너스볼입력테스트() {
        // 1등일 때
        LotteryNumber number = new LotteryNumber(Arrays.asList(1,2,3,4,5,6));
        int result = number.compareNumbers(new LotteryNumber(Arrays.asList(1,2,3,4,5,6), 7));
        assertThat(result).isEqualTo(6);

        // 2등일 때
        number = new LotteryNumber(Arrays.asList(1,2,3,4,5,6));
        result = number.compareNumbers(new LotteryNumber(Arrays.asList(1,2,3,4,5,7), 6));
        assertThat(result).isEqualTo(51);

        // 3등일 때
        number = new LotteryNumber(Arrays.asList(1,2,3,4,5,6));
        result = number.compareNumbers(new LotteryNumber(Arrays.asList(1,2,3,4,5,7), 8));
        assertThat(result).isEqualTo(5);

        // 4등일 때
        number = new LotteryNumber(Arrays.asList(1,2,3,4,5,6));
        result = number.compareNumbers(new LotteryNumber(Arrays.asList(1,2,3,4,7,8), 9));
        assertThat(result).isEqualTo(4);

        // 5등일 때
        number = new LotteryNumber(Arrays.asList(1,2,3,4,5,6));
        result = number.compareNumbers(new LotteryNumber(Arrays.asList(1,2,3,7,8,9), 10));
        assertThat(result).isEqualTo(3);


    }
}