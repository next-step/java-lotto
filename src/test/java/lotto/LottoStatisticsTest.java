package lotto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoStatisticsTest {

    @Test
    void rateOfReturnTest() {
        BigDecimal investment = BigDecimal.valueOf(14000);
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        for (int i = 0 ; i < 14; i++) {
            lottos.add(new Lotto(List.of(11, 12, 13, 24, 25, 26)));
        }

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, List.of(1, 2, 3, 14, 15, 16));
        BigDecimal result = lottoStatistics.rateOfReturn(investment);

        assertThat(result).isEqualTo(BigDecimal.valueOf(0.35));
    }

}