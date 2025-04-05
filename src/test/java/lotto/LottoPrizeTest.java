package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPrizeTest {

    @Test
    @DisplayName("일치하는 번호 개수에 따라 상금을 반환한다.")
    void shouldReturnCorrectPrizeBasedOnMatchCount() {
        assertThat(LottoPrize.getPrize(6)).isEqualTo(LottoPrize.SIX_MATCH);
    }

    @Test
    @DisplayName("일치하는 번호 개수가 0 ~ 6 이외의 값이면 예외가 발생한다.")
    void shouldThrowExceptionWhenMatchCountIsOutOfRange() {
        assertThatThrownBy(() -> LottoPrize.getPrize(7))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Invalid match count: 7");
    }

    @Test
    @DisplayName("전체 상금을 올바르게 계산한다.")
    void shouldCalculateTotalWinningAmountCorrectly() {
        Map<Integer, Integer> matchCounts = Map.of(
            6, 1,
            5, 2,
            4, 3,
            3, 4,
            2, 5
        );

        int expectedTotal = 2000000000 + 60000000 + 4500000 + 200000;
        assertThat(LottoPrize.calculateTotalWinningAmount(matchCounts)).isEqualTo(expectedTotal);
    }

    @Test
    @DisplayName("toString()이 올바른 형식으로 문자열을 반환한다.")
    void shouldReturnCorrectStringFormat() {
        assertThat(LottoPrize.SIX_MATCH.toString()).isEqualTo("6개 일치 (2000000000원)");
        assertThat(LottoPrize.FIVE_MATCH.toString()).isEqualTo("5개 일치 (30000000원)");
        assertThat(LottoPrize.FOUR_MATCH.toString()).isEqualTo("4개 일치 (1500000원)");
        assertThat(LottoPrize.THREE_MATCH.toString()).isEqualTo("3개 일치 (50000원)");
        assertThat(LottoPrize.TWO_MATCH.toString()).isEqualTo("2개 일치 (0원)");
    }
}
