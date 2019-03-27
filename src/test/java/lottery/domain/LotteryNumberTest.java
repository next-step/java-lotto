package lottery.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(value = BlockJUnit4ClassRunner.class)
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
        assertThat(result).isEqualTo(Fixture.numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호_모자라게_입력_테스트() {
        new LotteryNumber(Arrays.asList(1,2,3,4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스번호_중복_테스트() {
        new LotteryNumber(Fixture.numbers,6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복번호_입력_테스트() {
        new LotteryNumber(Arrays.asList(1,2,3,4,5,5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자_허용범위_테스트() {
        new LotteryNumber(Arrays.asList(1,2,3,4,5,70));
    }
    
    @Test
    public void 랭크리턴_테스트() {
        // 1등일 때
        LotteryNumber number = Fixture.createDefaultLotteryNumber;
        RANK result = number.compareNumbers(Fixture.createLotteryNumberWithBonus(7, 1,2,3,4,5,6));
        assertThat(result.getMatched()).isEqualTo(6);
        assertThat(result).isEqualTo(RANK.FIRST);

        // 2등일 때
        number = Fixture.createDefaultLotteryNumber;
        result = number.compareNumbers(Fixture.createLotteryNumberWithBonus(6,1,2,3,4,5,7));
        assertThat(result.getMatched()).isEqualTo(5);
        assertThat(result).isEqualTo(RANK.SECOND);

        // 3등일 때
        number = Fixture.createDefaultLotteryNumber;
        result = number.compareNumbers(Fixture.createLotteryNumberWithBonus(8,1,2,3,4,5,7));
        assertThat(result.getMatched()).isEqualTo(5);
        assertThat(result).isEqualTo(RANK.THIRD);
    }
}