package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RanksTest {

    @ParameterizedTest
    @CsvSource(value = {"10000L:100d", "20000L:200d"}, delimiter = ':')
    @DisplayName("수익률 반환")
    void returnProfitRatio(long money, double ratio) {
        // given
        Ranks ranks = new Ranks(List.of(Rank.THIRD, Rank.THIRD));
        // when
        double profitRatio = ranks.getProfitRatio(BigDecimal.valueOf(money));
        // then
        assertThat(profitRatio).isEqualTo(ratio);
    }

}