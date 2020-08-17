package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningResultTest {

    @DisplayName("WinningResult null 입력 생성 테스트")
    @Test
    void create_null() {
        String expectedMessage = LottoExceptionMessage.RESULT_IS_NULL;

        assertThatThrownBy(() -> WinningResult.of(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(expectedMessage);
    }

    @DisplayName("당첨 수익률 계산 테스트")
    @ParameterizedTest
    @MethodSource("makeCalculateWinningRate")
    void calculateWinningRate(Map<LottoRank, Long> lottoResultByRank, double expectedWinningRate) {
        WinningResult winningResult = WinningResult.of(lottoResultByRank);
        assertThat(winningResult.calculateWinningRate()).isEqualTo(expectedWinningRate);
    }

    private static Stream<Arguments> makeCalculateWinningRate() {
        // 구입 금액 : 7_000, 당첨 금액 : 1_550_000
        Map<LottoRank, Long> lottoResultByRank1 = new HashMap<>();
        lottoResultByRank1.put(LottoRank.FIRST, 0L);
        lottoResultByRank1.put(LottoRank.SECOND, 1L);
        lottoResultByRank1.put(LottoRank.THIRD, 1L);
        lottoResultByRank1.put(LottoRank.FOURTH, 0L);
        lottoResultByRank1.put(LottoRank.DROP, 5L);

        // 구입 금액 : 13_000, 당첨 금액 : 2_000_050_000
        Map<LottoRank, Long> lottoResultByRank2 = new HashMap<>();
        lottoResultByRank2.put(LottoRank.FIRST, 1L);
        lottoResultByRank2.put(LottoRank.SECOND, 0L);
        lottoResultByRank2.put(LottoRank.THIRD, 1L);
        lottoResultByRank2.put(LottoRank.FOURTH, 0L);
        lottoResultByRank2.put(LottoRank.DROP, 11L);

        return Stream.of(
                Arguments.of(lottoResultByRank1, 1_550_000D / 7_000D),
                Arguments.of(lottoResultByRank2, 2_000_050_000D / 13_000D)
        );
    }

}
