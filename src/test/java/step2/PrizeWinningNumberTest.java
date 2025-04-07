package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lottery.LotteryNumber;
import step2.winning.PrizeWinningNumber;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeWinningNumberTest {
    @Test
    @DisplayName("당첨 번호가 입력되지 않았을 때, 예외를 발생시킨다.")
    void nullInputTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber(null, 1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호가 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("당첨 번호가 빈 문자열일 때, 예외를 발생시킨다.")
    void emptyInputTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber("", 1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호가 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 때, 예외를 발생시킨다.")
    void wrongSizeTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber("1, 2, 3, 4, 5", 1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호의 개수가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("당첨 번호가 중복되었을 때, 예외를 발생시킨다.")
    void duplicateNumberTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber("1, 2, 3, 4, 5, 5", 6);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 숫자가 아닌 문자가 있을 때, 예외를 발생시킨다.")
    void notNumberTest() {
        assertThatThrownBy(() -> {
            new PrizeWinningNumber("1, 2, 3, 4, 5, a", 6);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호가 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("match 된 수를 반환한다")
    void matchCountTest() {
        PrizeWinningNumber prizeWinningNumber = new PrizeWinningNumber("1,2,3,4,5,6", 7);
        Set<LotteryNumber> numbers = Set.of(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(7)
        );
        assertThat(prizeWinningNumber.matchCount(numbers)).isEqualTo(2);
    }

    @Test
    @DisplayName("보너스 번호가 일치하는지 확인한다")
    void matchBonusTest() {
        PrizeWinningNumber prizeWinningNumber = new PrizeWinningNumber("1,2,3,4,5,6", 7);
        Set<LotteryNumber> numbers = Set.of(
                new LotteryNumber(1),
                new LotteryNumber(7)
        );
        assertThat(prizeWinningNumber.isMatchBounus(numbers)).isTrue();
    }
}
