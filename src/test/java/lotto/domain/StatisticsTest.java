package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("도메인 Statistics 테스트")
class StatisticsTest {

    @DisplayName("수익률 산출 테스트")
    @Test
    void getRateOfReturn() {
        Statistics statistics = new Statistics(List.of(Statistic.THREE, Statistic.FOUR));
        float result = statistics.getRateOfReturn();

        int totalPrice = Statistic.THREE.getPrice() + Statistic.FOUR.getPrice();
        float expected = (float) totalPrice / (2 * Lotto.LOTTO_PRICE);

        assertThat(result).isEqualTo(expected);
    }
}
