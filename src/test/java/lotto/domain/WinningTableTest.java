package lotto.domain;

import lotto.context.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("일치하는 수의 담청자 수를 증가시킨다.")
    void setAutoIncrementMatchCountResult() {
        winningTable.setAutoIncrementMatchCountResult(3);
        winningTable.setAutoIncrementMatchCountResult(3);
        Assertions.assertThat(winningTable.getMatchCountTable().get(Rank.getRank(3))).isEqualTo(2);
    }

    @Test
    void getTotalWinningMoney() {
        winningTable.setAutoIncrementMatchCountResult(3);
        Assertions.assertThat(winningTable.getTotalWinningMoney()).isEqualTo(Rank.FOURTH.getWinningMoney());
    }
}