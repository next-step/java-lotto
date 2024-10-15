package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStatisticsTest {

    @Test
    public void 매치_카운트가_증가하는지_확인한다() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.incrementMatchCount(5, false);
        assertThat(lottoStatistics.getCountByMatchCount(5, false)).isEqualTo(1);
    }

    @Test
    public void 유효하지_않은_매치_수를_입력하면_예외가_발생한다() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        assertThatThrownBy(() -> lottoStatistics.incrementMatchCount(7, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 매치 수:");
    }

    @Test
    public void 특정_매치_수에_대한_상금을_조회한다() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        int prizeMoney = lottoStatistics.getPrizeMoney(4, false);
        assertThat(prizeMoney).isEqualTo(50000);
    }

    @Test
    public void 특정_매치_수에_대한_일치_개수를_조회한다() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.incrementMatchCount(5, false);
        int count = lottoStatistics.getCountByMatchCount(5, false);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 수익을_계산하는지_확인한다() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.incrementMatchCount(3, false);
        lottoStatistics.incrementMatchCount(4, false);
        int earnings = lottoStatistics.getEarningsByMatchCount(3, false);
        assertThat(earnings).isEqualTo(lottoStatistics.getPrizeMoney(3, false) * lottoStatistics.getCountByMatchCount(3, false));
    }
}
