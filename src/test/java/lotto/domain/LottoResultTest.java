package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("모든 로또의 결과 `LottoResult`에 대한 테스트")
class LottoResultTest {
    private final List<LottoResultType> lottoResultTypes = Arrays.stream(LottoResultType.values()).collect(Collectors.toList());
    private final LottoResult lottoResult = new LottoResult(lottoResultTypes);

    @DisplayName("`LottoResult` 생성")
    @Test
    void createLottoResultTest() {
        // When
        LottoResult lottoResult = new LottoResult(lottoResultTypes);
        // Then
        assertThat(lottoResult).isNotNull();
    }

    @DisplayName("`LottoResult` 수익률 반환")
    @Test
    void getEarningsRatioTest() {
        // When
        double earningsRatio = lottoResult.getEarningsRatio();
        // Then
        assertThat(earningsRatio).isNotNegative();
    }

    @DisplayName("`LottoResult` 통계 반환")
    @Test
    void getStatisticsTest() {
        // When
        Map<LottoResultType, Integer> earningsRatio = lottoResult.getStatistics();
        // Then
        assertThat(earningsRatio.values())
                .hasSize(earningsRatio.values().size())
                .containsOnly(1);
    }
}
