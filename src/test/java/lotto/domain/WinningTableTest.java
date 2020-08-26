package lotto.domain;

import lotto.context.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class WinningTableTest {
    WinningTable winningTable;

    @BeforeEach
    void create() {
        winningTable = new WinningTable();
    }

    @Test
    void getMatchCountTable() {
        Assertions.assertThat(winningTable.getMatchCountTable()).containsKeys(Rank.values());
    }

    @Test
    void setAutoIncrementMatchCountResult() {
        winningTable.setAutoIncrementMatchCountResult(3);
        winningTable.setAutoIncrementMatchCountResult(3);
        Assertions.assertThat(winningTable.getMatchCountTable().get(Rank.getRank(3))).isEqualTo(2);
    }

    @Test
    void calculationEarningsRate() {
        winningTable.setAutoIncrementMatchCountResult(3);
        System.out.println(winningTable.calculationEarningsRate(14000));
        Assertions.assertThat(winningTable.calculationEarningsRate(14000)).isEqualTo(0.35);
    }
}