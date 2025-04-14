package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @Test
    void 수익률_계산_테스트() {
        List<Rank> ranks = Arrays.asList(
            Rank.FIFTH
        );
        LottoStatistics lottoStatistics = new LottoStatistics(ranks, 14);

        assertThat(lottoStatistics.getProfitRate()).isEqualTo("0.35");
    }

    @Test
    void 수익률이_1_초과이면_isProfit_true() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIFTH);
        ranks.add(Rank.FIFTH);
        ranks.add(Rank.FIFTH);

        LottoStatistics highProfitStatics = new LottoStatistics(
            ranks, 10
        );

        assertThat(highProfitStatics.isProfit()).isTrue();
    }

        @Test
    void 수익률이_1_이하이면_isProfit_false() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIFTH);
        ranks.add(Rank.FIFTH);

        LottoStatistics highProfitStatics = new LottoStatistics(
            ranks, 10
        );

        assertThat(highProfitStatics.isProfit()).isFalse();
    }
}
