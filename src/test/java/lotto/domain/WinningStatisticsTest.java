package lotto.domain;

import lotto.domain.exception.InvalidWinningCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("당첨 통계 테스트")
public class WinningStatisticsTest {
    WinningStatistics statistics = WinningStatistics.empty();

    @DisplayName("당첨 통계 초기값")
    @Test
    public void initialWinningStatistics() {
        for (int winningCount = 0; winningCount <= 6; winningCount++) {
            int count = statistics.getWinningLottoCount(winningCount);

            assertThat(count).isEqualTo(0);
        }
    }

    @DisplayName("당첨 통계 누적")
    @ParameterizedTest
    @MethodSource("getWinningCounts")
    public void accumulateStatistics(int winningCount) {
        statistics.increaseWinningLottoCount(winningCount);

        int lottoCount = statistics.getWinningLottoCount(winningCount);

        assertThat(lottoCount).isEqualTo(1);
    }

    static Stream<Integer> getWinningCounts() {
        return IntStream.range(0, 7).boxed();
    }

    @DisplayName("0보다 작거나 6보다 큰 당첨 숫자 개수로 누적")
    @ParameterizedTest
    @MethodSource("getInvalidWinningCounts")
    public void accumulateInvalidStatistics(int winningCount) {
        assertThatThrownBy(() -> {
            statistics.increaseWinningLottoCount(winningCount);
        }).isInstanceOf(InvalidWinningCountException.class)
                .hasMessageContaining("잘못된 당첨 숫자 개수입니다.");
    }

    static Stream<Integer> getInvalidWinningCounts() {
        return Stream.of(-1, 7, 8);
    }

    @DisplayName("0보다 작거나 6보다 큰 당첨 숫자 개수로 조회")
    @ParameterizedTest
    @MethodSource("getInvalidWinningCounts")
    public void getInvalidStatistics(int winningCount) {
        assertThatThrownBy(() -> {
            statistics.getWinningLottoCount(winningCount);
        }).isInstanceOf(InvalidWinningCountException.class)
                .hasMessageContaining("잘못된 당첨 숫자 개수입니다.");
    }

    @DisplayName("당첨 통계를 기준으로 당첨 금액 계산")
    @Test
    public void getRevenue() {
        WinningStatistics statistics = WinningStatistics.of(new HashMap<Integer, Integer>() {{
            put(3, 1);
            put(4, 1);
            put(5, 1);
            put(6, 0);
        }});

        int revenue = statistics.calculateRevenue();

        assertThat(revenue).isEqualTo(1555000);
    }
}