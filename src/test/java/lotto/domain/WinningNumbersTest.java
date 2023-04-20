package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        final String args = "1, 2, 3, 4, 5, 6";
        final WinningNumbers winningNumbers = new WinningNumbers(args);

        assertThat(winningNumbers)
                .isEqualTo(new WinningNumbers(args));
    }

    @Test
    @DisplayName("우승넘버 가리기")
    void isWinning() {
        final String args = "1, 2, 3, 4, 5, 6";
        final WinningNumbers winningNumbers = new WinningNumbers(args);


    }
}
