package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.MatchNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoStatisticsTest {

    @DisplayName("구매금액과 맞은 갯수 리스트를 전달하면 로또 통계 객체를 생성한다.")
    @Test
    void lottoStatisticsCreateTest() {
        MatchNumbers matchNumbers = new MatchNumbers();
        matchNumbers.add(3);
        matchNumbers.add(4);

        assertThat(new LottoStatistics(2000, matchNumbers))
                .isInstanceOf(LottoStatistics.class);
    }

    @DisplayName("구매금액과 맞는 갯수 리스트를 전달하면 로또 통계를 가져올 수 있다.")
    @Test
    void lottoStatisticsRateTest() {
        MatchNumbers matchNumbers = new MatchNumbers();
        matchNumbers.add(3);
        matchNumbers.add(4);
        LottoStatistics lottoStatistics = new LottoStatistics(2000, matchNumbers);

        assertThat(lottoStatistics.getRate()).isEqualTo(27.5);
    }
}
