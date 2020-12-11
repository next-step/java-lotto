package lotto.domain;

import lotto.domain.LottoReport;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 결과(LottoReport) 테스트")
public class LottoReportTest {

    private LottoReport lottoReport;

    @BeforeEach
    void setUp() {
        lottoReport = LottoReport.of(Rank.FIRST, Rank.SECOND, Rank.THIRD);
    }

    @DisplayName("로도 결과는 등수들로 이루어진다.")
    @Test
    void create() {
        // then
        assertThat(lottoReport).isNotNull();
    }

    @DisplayName("각 등수 별 당첨 수를 확인할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"FIRST,1", "SECOND,1", "THIRD,1", "FOURTH,0", "UN_RANK,0"})
    void count(String value, int expected) {
        // given
        Rank rank = Rank.valueOf(value);

        // when
        int count = lottoReport.count(rank);

        // then
        assertThat(count).isEqualTo(expected);
    }

    @DisplayName("수익률을 구할 수 있다")
    @Test
    void profitRate() {
        // given
        LottoReport fourth = LottoReport.of(Rank.FOURTH, Rank.UN_RANK, Rank.UN_RANK);

        // when
        double rate = fourth.profitRate();

        // then
        assertThat(rate).isEqualTo(1.66);
    }

}
