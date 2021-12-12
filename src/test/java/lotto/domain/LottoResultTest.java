package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("모든 로또의 결과 `LottoResult`에 대한 테스트")
class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        Lottos purchasedLottos = new Lottos(Arrays.asList(new Lotto(), new Lotto(), new Lotto()));
        Lotto winningLotto = new Lotto();
        lottoResult = new LottoResult(purchasedLottos, winningLotto);
    }

    @DisplayName("`LottoResult` 생성")
    @Test
    void createLottoResultTest() {
        // then
        assertThat(lottoResult).isNotNull();
    }

    @DisplayName("`LottoResult` 수익률 반환")
    @Test
    void earningsRatioTest() {
        // when
        double earningsRatio = lottoResult.earningsRatio();
        // then
        assertThat(earningsRatio).isNotNegative();
    }

    @DisplayName("`LottoResult` 통계 반환")
    @Test
    void statisticsTest() {
        // when
        Map<LottoRank, Integer> earningsRatio = lottoResult.getStatistics();
        // then
        assertThat(earningsRatio.values())
                .hasSize(LottoRank.values().length);
    }

    @DisplayName("`LottoResult`의 통계 타입별 결과 갯수 반환")
    @ParameterizedTest
    @EnumSource(LottoRank.class)
    void countByTypeTest(LottoRank type) {
        // when & then
        assertThat(lottoResult.countByType(type)).isNotNegative();
    }
}
