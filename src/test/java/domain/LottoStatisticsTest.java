package domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @Test
    void 정상당첨테스트() {
        List<Lotto> lottoList = this.createLotto();
        LottoStatistics lottoStatistics = new LottoStatistics(lottoList);

        assertThat(lottoStatistics.getCountByRank(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoStatistics.getCountByRank(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoStatistics.getCountByRank(Rank.THIRD)).isEqualTo(0);
        assertThat(lottoStatistics.getCountByRank(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoStatistics.getCountByRank(Rank.FIFTH)).isEqualTo(1);
        assertThat(lottoStatistics.getCountByRank(Rank.MISS)).isEqualTo(0);
    }

    @Test
    void 수익률_계산_테스트() {
        List<Lotto> lottoList = this.createLotto();
        LottoStatistics lottoStatistics = new LottoStatistics(lottoList);

        assertThat(lottoStatistics.getProfitRate()).isEqualTo("507513.75");
    }

    @Test
    void 수익률이_1_이상이면_isProfit_true() {
        LottoStatistics highProfitStatics = new LottoStatistics(
            List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6),
                    new WinningNumbers(Arrays.asList(1,2,3,4,5,7),6)
                ))
        );

        assertThat(highProfitStatics.isProfit()).isTrue();
    }

    private List<Lotto> createLotto() {
        List<Lotto> lottoList = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        for (Lotto lotto : lottoList) {
            lotto.matchRank(new WinningNumbers(Arrays.asList(1,2,3,4,5,6),9));
        }

        return lottoList;
    }
}
