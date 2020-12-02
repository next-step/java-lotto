package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoFactoryTest {

    @Test
    void createLottoTest() {
        assertThat(LottoFactory.createLotto(3).size()).isEqualTo(3);
    }

    @Test
    void createLotto_FailureTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoFactory.createLotto(0))
                .withMessageMatching("구입 금액을 잘못 입력했습니다.");
    }

    @Test
    void getLastWeekWinningNumbersTest() {
        String input = "1, 2, 3, 4, 5, 6";
        assertThat(LottoFactory.getLastWeekWinningNumbers(input).size()).isEqualTo(6);
    }

    @Test
    void getLastWeekWinningNumbers_FailureTest() {
        String input = "";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoFactory.getLastWeekWinningNumbers(input))
                .withMessageMatching("잘못 된 당첨 번호를 입력했습니다.");
    }
}
