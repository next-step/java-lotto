package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoReportTest {

    @Test
    public void 리포트_수익률_계산() {
        Map<LottoRank, Long> result = Map.of(
                LottoRank.THIRD, 1L,
                LottoRank.FIFTH, 2L,
                LottoRank.LAST, 1L
        );

        Assertions.assertThat(new LottoReport(result).rateOfReturn())
                .isEqualTo(377.5);
    }
}
