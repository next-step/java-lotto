package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    @DisplayName(value = "구매한 금액에 따라서 수익률을 계산할 수 있다")
    @Test
    void calcLottoEarningRate() {
        List<Rank> ranks = new ArrayList<>();
        LottoStatistics lottoStatistics = new LottoStatistics(ranks);
        ranks.add(Rank.FIRST);
        assertThat(lottoStatistics.getLottoEarningRate(new LottoPrice(5000))).isEqualTo("400000.00");
    }
}
