package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    @Test
    void createLottoTest() {
        assertThat(LottoFactory.createLotto(3).size()).isEqualTo(3);
    }

    @Test
    void getLastWeekWinningNumbersTest() {
        String input = "1, 2, 3, 4, 5, 6";
        assertThat(LottoFactory.getLastWeekWinningNumbers(input).size()).isEqualTo(6);
    }
}
