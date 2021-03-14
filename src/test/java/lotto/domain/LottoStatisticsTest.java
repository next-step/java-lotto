package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoStatisticsTest {

    @Test
    @DisplayName("수익률 확인")
    public void calculate() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.put(LottoRank.FOURTH);
        assertEquals(0.35,lottoStatistics.calculate(14000));
    }


}
