package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStatisticsTest {

    @Test
    public void 매치_카운트가_증가하는지_확인한다() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.incrementMatchCount(3);
        assertThat(lottoStatistics.getCountByMatchCount(3)).isEqualTo(1);
    }

    @Test
    public void 유효하지_않은_매치_수를_입력하면_예외가_발생한다() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        assertThatThrownBy(() -> lottoStatistics.incrementMatchCount(7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 매치 수:");
    }

    @Test
    public void 특정_매치_수에_대한_상금을_조회한다() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        int prizeMoney = lottoStatistics.getPrizeMoney(4);
        assertThat(prizeMoney).isEqualTo(50000);
    }

    @Test
    public void 특정_매치_수에_대한_일치_개수를_조회한다() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.incrementMatchCount(5);
        int count = lottoStatistics.getCountByMatchCount(5);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 수익을_계산하는지_확인한다() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.incrementMatchCount(3);
        lottoStatistics.incrementMatchCount(4);
        int earnings = lottoStatistics.getEarningsByMatchCount(3);
        assertThat(earnings).isEqualTo(lottoStatistics.getPrizeMoney(3) * lottoStatistics.getCountByMatchCount(3));
    }
}
