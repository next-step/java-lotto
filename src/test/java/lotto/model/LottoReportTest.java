package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoReportTest {

    @Test
    public void 리포트_수익률_계산() {
        List<LottoRank> result = Arrays.asList(
                LottoRank.THIRD,
                LottoRank.FIFTH,
                LottoRank.FIFTH,
                LottoRank.COLLECT_0
        );

        Assertions.assertThat(new LottoReport(result).rateOfReturn())
                .isEqualTo(377.5);
    }
}
