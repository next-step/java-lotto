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
        Lottos lottos = new Lottos(getLotto(LottoType.AUTO, 1, 2, 3, 4, 5, 6), getLotto(LottoType.AUTO, 1, 2, 3, 4, 5, 11
        ),
                                   getLotto(LottoType.AUTO, 11, 12, 13, 14, 15, 16));
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), new LottoNumber(45));
        WinStatistics winStatistics = new WinStatistics(lottos, winNumbers);

        List<WinType> winTypes = winStatistics.winStatistics();

        assertThat(winTypes).containsExactly(WinType.FIRST, WinType.THIRD, WinType.FAIL);
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void test02() {
        Lottos lottos = new Lottos(getLotto(LottoType.AUTO, 1, 2, 3, 4, 5, 6), getLotto(LottoType.AUTO, 11, 12, 13, 14, 15, 16
        ),
                                   getLotto(LottoType.AUTO, 11, 12, 13, 14, 15, 16));
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), new LottoNumber(45));
        WinStatistics winStatistics = new WinStatistics(lottos, winNumbers);

        BigDecimal rateOfReturn = winStatistics.rateOfReturn();

        assertThat(rateOfReturn).isEqualTo(new BigDecimal("666666.66"));
    }

    private Lotto getLotto(LottoType lottoType, int num1, int num2, int num3, int num4, int num5, int num6) {
        return new Lotto(lottoType, num1, num2, num3, num4, num5, num6);
    }
}
