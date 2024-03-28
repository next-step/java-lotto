package lottery.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryNumbersTest {

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void lotteryNumbersTest() {
        // Given
        final String numbersString = "1, 2, 3, 4, 5, 6";

        // When
        LotteryNumbers lotteryNumbers = new LotteryNumbers(numbersString);

        // Then
        assertThat(lotteryNumbers.numbers()).hasSize(LotteryNumbers.SIZE);
        assertThat(lotteryNumbers.numbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("잘못된 로또 번호 개수 테스트")
    void unavailableLotteryNumbersThrowExceptionTest() {
        // Given
        final String numbersString = "1, 2, 3, 4, 5";

        // When
        assertThatThrownBy(() -> {
            new LotteryNumbers(numbersString);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개만 가능합니다");
    }

    @Test
    @DisplayName("번호 일치 개수 테스트")
    void matchNumbersCountTest() {
        // Given
        final LotteryNumbers lotteryNumbers = new LotteryNumbers("1, 2, 3, 4, 5, 6");
        final Set<Integer> otherNumbers = Set.of(3, 4, 5, 6, 7, 8);

        // When
        Long actual = lotteryNumbers.matchNumbersCount(otherNumbers);

        // Then
        Long expected = 4L;
        assertThat(actual).isEqualTo(expected);
    }
}
