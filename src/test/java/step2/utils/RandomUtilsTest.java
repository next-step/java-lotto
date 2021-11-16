package step2.utils;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilsTest {
    
    @RepeatedTest(10)
    void 범위_1_이상_45_이하의_랜덤한_숫자를_생성한다() {
        //given
        int number = RandomUtils.nextInt();
        //when & then
        assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
    }
}
