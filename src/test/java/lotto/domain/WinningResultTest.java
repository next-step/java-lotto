package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    @DisplayName("6개부터 1개까지 매칭된 총 상금을 구한다.")
    @Test
    void total_price() {

        final List<WinningPrize> resultList = List.of(WinningPrize.from(6, false)
                , WinningPrize.from(5, false)
                , WinningPrize.from(5, true)
                , WinningPrize.from(4, false)
                , WinningPrize.from(3, false)
                , WinningPrize.from(2, false)
                , WinningPrize.from(1, false));
        final WinningResult winningResult = WinningResult.init();
        winningResult.collect(resultList);

        assertThat(winningResult.sum()).isEqualTo(new BigDecimal(2_031_555_000));
    }

    @DisplayName("5개 매칭된 등수가 2개인 우승 상금을 구한다.")
    @Test
    void tie_price() {

        final List<WinningPrize> resultList = List.of(WinningPrize.from(5, false)
                , WinningPrize.from(5, true));
        final WinningResult winningResult = WinningResult.init();
        winningResult.collect(resultList);

        assertThat(winningResult.sum()).isEqualTo(new BigDecimal(31_500_000));
    }
}
