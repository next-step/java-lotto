package lotto.dto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @DisplayName("LottoStatistics 생성 테스트")
    @Test
    void of() {
        BigDecimal profileRate = new BigDecimal("3.33");

        List<LottoRank> lottoRanks = Arrays.asList(
                LottoRank.FOURTH,
                LottoRank.FOURTH,
                LottoRank.NONE
        );

        LottoStatistics statistics = LottoStatistics.of(profileRate, lottoRanks);

        assertThat(statistics.getStatisticsValue().get(0).getLottoCount()).isEqualTo(2);
        assertThat(statistics.getStatisticsValue().get(1).getLottoCount()).isZero();
        assertThat(statistics.getStatisticsValue().get(2).getLottoCount()).isZero();
        assertThat(statistics.getStatisticsValue().get(3).getLottoCount()).isZero();
    }
}
