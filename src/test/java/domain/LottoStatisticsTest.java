package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @Before
    public void setup() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        lottoStatistics = new LottoStatistics(winningNumbers);
    }

    @Test
    public void 당첨통계_0개일치_확인() {
        List<Integer> lottoNumbers = lottoStatistics.getNumbers("8, 10, 20, 30 ,40, 45");
        Jackpot jackpot = lottoStatistics.getJackpot(lottoNumbers);
        assertThat(jackpot).isEqualTo(Jackpot.SAME_0_NUMBERS);
    }

    @Test
    public void 당첨통계_3개일치_확인() {
        List<Integer> lottoNumbers = lottoStatistics.getNumbers("1, 2, 3, 23, 35, 37");
        Jackpot jackpot = lottoStatistics.getJackpot(lottoNumbers);
        assertThat(jackpot).isEqualTo(Jackpot.SAME_3_NUMBERS);
    }

    @Test
    public void 당첨통계_4개일치_확인() {
        List<Integer> lottoNumbers = lottoStatistics.getNumbers("1, 2, 3, 4, 35, 37");
        Jackpot jackpot = lottoStatistics.getJackpot(lottoNumbers);
        assertThat(jackpot).isEqualTo(Jackpot.SAME_4_NUMBERS);
    }

    @Test
    public void 당첨통계_5개일치_확인() {
        List<Integer> lottoNumbers = lottoStatistics.getNumbers("1, 2, 3, 4, 5, 42");
        Jackpot jackpot = lottoStatistics.getJackpot(lottoNumbers);
        assertThat(jackpot).isEqualTo(Jackpot.SAME_5_NUMBERS);
    }

    @Test
    public void 당첨통계_6개일치_확인() {
        List<Integer> lottoNumbers = lottoStatistics.getNumbers("1, 2, 3, 4, 5, 6");
        Jackpot jackpot = lottoStatistics.getJackpot(lottoNumbers);
        assertThat(jackpot).isEqualTo(Jackpot.SAME_6_NUMBERS);
    }
}
