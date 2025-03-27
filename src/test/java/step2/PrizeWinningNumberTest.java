package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeWinningNumberTest {
    @Test
    @DisplayName("당첨 번호가 입력되지 않았을 때, 예외를 발생시킨다.")
    void nullInputTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호가 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("당첨 번호가 빈 문자열일 때, 예외를 발생시킨다.")
    void emptyInputTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호가 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 때, 예외를 발생시킨다.")
    void wrongSizeTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber("1, 2, 3, 4, 5");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 결과의 개수가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("당첨 번호가 중복되었을 때, 예외를 발생시킨다.")
    void duplicateNumberTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber("1, 2, 3, 4, 5, 5");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("당첨 번호가 숫자가 아닌 문자가 있을 때, 예외를 발생시킨다.")
    void notNumberTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber("1, 2, 3, 4, 5, a");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 결과가 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("당첨 번호의 범위가 올바르지 않을 때, 예외를 발생시킨다.")
    void outOfRangeTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber("1, 2, 3, 4, 5, 46");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호의 범위가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("당첨 번호가 음수가 있을 때, 예외를 발생시킨다.")
    void negativeNumberTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber("1, 2, 3, 4, 5, -1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호의 범위가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("당첨 번호가 정상일때, 객체를 생성한다")
    void createPrizeWinningNumberTest() {
        PrizeWinningNumber prizeWinningNumber = new PrizeWinningNumber("1, 2, 3, 4, 5, 6");
        assertThat(prizeWinningNumber.getPrizeWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
