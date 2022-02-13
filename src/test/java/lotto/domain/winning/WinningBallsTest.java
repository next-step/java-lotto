package lotto.domain.winning;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class WinningBallsTest {

    @Test
    void 보너스번호_당첨번호_중복_확인() {
        String[] numbers = {"1", "2", "3", "4", "5", "6"};
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningBalls(numbers, "6"))
            .withMessage("[ERROR] 보너스 번호와 당첨 번호가 같습니다.");
    }
}
