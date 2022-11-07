package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

class LottoResultStatisticsTest {

    private static LottoResultStatistics stats;

    @BeforeEach
    void setUp() {
        stats = new LottoResultStatistics(
            Arrays.asList(
                LottoResult.FIRST,
                LottoResult.FIRST,
                LottoResult.SECOND,
                LottoResult.SECOND,
                LottoResult.SECOND,
                LottoResult.THIRD,
                LottoResult.THIRD,
                LottoResult.THIRD,
                LottoResult.FOURTH,
                LottoResult.FOURTH,
                LottoResult.FOURTH,
                LottoResult.FOURTH
            ));
    }

    @DisplayName("주어진 로또 결과 목록이 비어있다면, 모든 결과 카운트는 0이어야 한다")
    @ParameterizedTest
    @EmptySource
    void getRankCount_empty(final List<LottoResult> lottoResults) {
        stats = new LottoResultStatistics(lottoResults);
        assertAll(
            () -> assertThat(stats.getFirstRankCount()).isZero(),
            () -> assertThat(stats.getSecondRankCount()).isZero(),
            () -> assertThat(stats.getThirdRankCount()).isZero(),
            () -> assertThat(stats.getFourthRankCount()).isZero()
        );
    }

    @DisplayName("주어진 로또 결과 목록이 비어있어도, 모든 결과가 가져야 하는 상금금액은, 반환 할 수 있어야 한다")
    @ParameterizedTest
    @EmptySource
    void getPrizeMoney_empty(final List<LottoResult> lottoResults) {
        stats = new LottoResultStatistics(lottoResults);
        assertAll(
            () -> assertThat(stats.getFirstRankPrizeMoney())
                .isEqualTo(LottoResult.FIRST.getPrizeMoney()),
            () -> assertThat(stats.getSecondRankPrizeMoney())
                .isEqualTo(LottoResult.SECOND.getPrizeMoney()),
            () -> assertThat(stats.getThirdRankPrizeMoney())
                .isEqualTo(LottoResult.THIRD.getPrizeMoney()),
            () -> assertThat(stats.getFourthRankPrizeMoney())
                .isEqualTo(LottoResult.FOURTH.getPrizeMoney())
        );
    }

    @DisplayName("주어진 로또 결과 목록이 비어있어도, 모든 결과가 가져야 하는 로또넘버매치개수는, 반환 할 수 있어야 한다")
    @ParameterizedTest
    @EmptySource
    void getRankLottoNumberMatchCount_empty(final List<LottoResult> lottoResults) {
        stats = new LottoResultStatistics(lottoResults);
        assertAll(
            () -> assertThat(stats.getFirstRankLottoNumberMatchCount())
                .isEqualTo(LottoNumberMatchCount.ALL),
            () -> assertThat(stats.getSecondRankLottoNumberMatchCount())
                .isEqualTo(LottoNumberMatchCount.FIVE),
            () -> assertThat(stats.getThirdRankLottoNumberMatchCount())
                .isEqualTo(LottoNumberMatchCount.FOUR),
            () -> assertThat(stats.getFourthRankLottoNumberMatchCount())
                .isEqualTo(LottoNumberMatchCount.THREE)
        );
    }

    @DisplayName("주어진 로또 결과 목록이 non-empty라면, 모든 결과 카운트는, 주어진 목록에 맞게 반환해야 한다")
    @Test
    void getRankCount() {
        assertAll(
            () -> assertThat(stats.getFirstRankCount()).isEqualTo(2),
            () -> assertThat(stats.getSecondRankCount()).isEqualTo(3),
            () -> assertThat(stats.getThirdRankCount()).isEqualTo(3),
            () -> assertThat(stats.getFourthRankCount()).isEqualTo(4)
        );
    }

    @DisplayName("주어진 로또 결과 목록이 non-empty라면, 모든 결과가 가져야 하는 상금금액은, 반환 할 수 있어야 한다")
    @Test
    void getPrizeMoney() {
        assertAll(
            () -> assertThat(stats.getFirstRankPrizeMoney())
                .isEqualTo(LottoResult.FIRST.getPrizeMoney()),
            () -> assertThat(stats.getSecondRankPrizeMoney())
                .isEqualTo(LottoResult.SECOND.getPrizeMoney()),
            () -> assertThat(stats.getThirdRankPrizeMoney())
                .isEqualTo(LottoResult.THIRD.getPrizeMoney()),
            () -> assertThat(stats.getFourthRankPrizeMoney())
                .isEqualTo(LottoResult.FOURTH.getPrizeMoney())
        );
    }

    @DisplayName("주어진 로또 결과 목록이 non-empty라면, 모든 결과가 가져야 하는 로또넘버매치개수는, 반환 할 수 있어야 한다")
    @Test
    void getRankLottoNumberMatchCount() {
        assertAll(
            () -> assertThat(stats.getFirstRankLottoNumberMatchCount())
                .isEqualTo(LottoNumberMatchCount.ALL),
            () -> assertThat(stats.getSecondRankLottoNumberMatchCount())
                .isEqualTo(LottoNumberMatchCount.FIVE),
            () -> assertThat(stats.getThirdRankLottoNumberMatchCount())
                .isEqualTo(LottoNumberMatchCount.FOUR),
            () -> assertThat(stats.getFourthRankLottoNumberMatchCount())
                .isEqualTo(LottoNumberMatchCount.THREE)
        );
    }

}