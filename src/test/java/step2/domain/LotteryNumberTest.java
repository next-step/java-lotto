package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryNumberTest {

    @Test
    void 로또_번호_생성_테스트() {
        LotteryNumber lotteryNumber = new LotteryNumber();
        assertThat(lotteryNumber.createLotteryNumber()).hasSize(6);
    }
}