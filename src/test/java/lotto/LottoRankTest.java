package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("번호 일치 개수에 따라 적절한 등수를 가져온다.")
    void shouldReturnCorrectRankBasedOnMatchCount() {
        assertThat(LottoRank.getPrize(6, false)).isEqualTo(LottoRank.First);
        assertThat(LottoRank.getPrize(5, true)).isEqualTo(LottoRank.Second);
    }

    @Test
    @DisplayName("일치하는 번호 개수가 0 ~ 6 이외의 값이면 예외가 발생한다.")
    void shouldThrowExceptionWhenMatchCountIsOutOfRange() {
        assertThatThrownBy(() -> LottoRank.getPrize(7, false))
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
            3, 4
        );

        int expectedTotal = 2000000000 + 1500000 * 2 + 50000 * 3 + 5000 * 4;
        assertThat(LottoRank.calculateTotalWinningAmount(matchCounts)).isEqualTo(expectedTotal);
    }

    @Test
    @DisplayName("toString()이 올바른 형식으로 문자열을 반환한다.")
    void shouldReturnCorrectStringFormat() {
        assertThat(LottoRank.First.toString()).isEqualTo("6개 일치 (2000000000원)");
    }
}
