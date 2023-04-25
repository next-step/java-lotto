package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinStatisticsTest {
    @Test
    @DisplayName("당첨번호와, 로또들을 비교하여 3개~6개 일치하는 수량을 가지고 있는다.")
    void test01() {
        Lottos lottos = new Lottos(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(1, 2, 3, 4, 5, 45),
                                   new Lotto(40, 41, 42, 43, 44, 45));
        WinNumbers winNumbers = new WinNumbers(1, 2, 3, 4, 5, 6);
        WinStatistics winStatistics = new WinStatistics(lottos, winNumbers);

        List<WinType> winTypes = winStatistics.winStatistics();

        assertThat(winTypes).containsExactly(WinType.FIRST, WinType.THIRD, WinType.FAIL);
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void test02() {
        Lottos lottos = new Lottos(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(40, 41, 42, 43, 44, 45),
                                   new Lotto(40, 41, 42, 43, 44, 45));
        WinNumbers winNumbers = new WinNumbers(1, 2, 3, 4, 5, 6);
        WinStatistics winStatistics = new WinStatistics(lottos, winNumbers);

        BigDecimal rateOfReturn = winStatistics.rateOfReturn();

        assertThat(rateOfReturn).isEqualTo(new BigDecimal("666666.66"));
    }
}
