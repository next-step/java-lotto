package lotto.domain;

import lotto.context.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

class WinningResultTest {
    WinningResult winningResult;
    @BeforeEach
    void create() {
        winningResult = new WinningResult("1, 2, 3, 4, 5, 6");
    }

    @ParameterizedTest
    @EnumSource(Rank.class)
    void getMatchCountResult(Rank rank) {
        Assertions.assertThat(winningResult.getMatchCountResult()).containsKeys(rank);
    }

    @Test
    void setAutoIncrement() {
        winningResult.setAutoIncrement(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(winningResult.getMatchCountResult().get(Rank.getRank(6))).isEqualTo(1);
        Assertions.assertThat(winningResult.getMatchCountResult().get(Rank.getRank(5))).isEqualTo(0);
    }

    @Test
    void calculationEarningsRate() {
        winningResult.setAutoIncrement(Arrays.asList(1, 2, 3));
        Assertions.assertThat(winningResult.calculationEarningsRate(14000)).isEqualTo(0.35);
    }
}