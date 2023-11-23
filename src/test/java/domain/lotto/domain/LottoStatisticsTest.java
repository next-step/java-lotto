package domain.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    private final List<LottoLine> mockLottoLines = List.of(
            LottoLine.create(Set.of(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                    LottoNumber.from(6)
            )),
            LottoLine.create(Set.of(
                    LottoNumber.from(11),
                    LottoNumber.from(12),
                    LottoNumber.from(13),
                    LottoNumber.from(14),
                    LottoNumber.from(15),
                    LottoNumber.from(16)
            )),
            LottoLine.create(Set.of(
                    LottoNumber.from(21),
                    LottoNumber.from(22),
                    LottoNumber.from(23),
                    LottoNumber.from(24),
                    LottoNumber.from(25),
                    LottoNumber.from(26))
            ));

    @DisplayName("로또 통계 계산 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void calculate_statistics_success(int input) {
        LottoStatistics lottoStatistics = new LottoStatistics();

        lottoStatistics.calculate(input, false);
        assertThat(lottoStatistics.getRankCounts().get(Rank.valueOf(input)))
                .isEqualTo(1);
    }

    @DisplayName("로또 통계 2등 (보너스볼) 계산 성공")
    @Test
    void calculate_statistics_second_success() {
        LottoStatistics lottoStatistics = new LottoStatistics();

        lottoStatistics.calculate(5, true);

        assertThat(lottoStatistics.getRankCounts())
                .containsEntry(Rank.SECOND, 1);
        assertThat(lottoStatistics.getRankCounts())
                .containsEntry(Rank.THIRD, 0);
    }
}
