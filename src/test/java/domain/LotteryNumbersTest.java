package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryNumbersTest {

    @Test
    @DisplayName("랜덤번호 6개 생성")
    public void sixRandomNumber() {
        assertThat(LotteryNumbers.auto().size()).isEqualTo(6);
    }
}
