package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    @DisplayName("6개부터 1개까지 매칭된 총 상금을 구한다.")
    @Test
    void total_price() {

        final List<Integer> resultList = List.of(6, 5, 4, 3, 2, 1);
        final WinningResult winningResult = WinningResult.init();
        winningResult.collect(resultList);

        assertThat(winningResult.sum()).isEqualTo(new BigDecimal(2001555000));
    }

    @DisplayName("5개 매칭된 등수가 2개인 우승 상금을 구한다.")
    @Test
    void tie_price() {

        final List<Integer> resultList = List.of(5, 5);
        final WinningResult winningResult = WinningResult.init();
        winningResult.collect(resultList);

        assertThat(winningResult.sum()).isEqualTo(new BigDecimal(3000000));
    }
}
