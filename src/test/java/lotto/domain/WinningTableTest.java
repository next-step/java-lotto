package lotto.domain;

import lotto.context.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTableTest {
    WinningTable winningTable;

    @BeforeEach
    void create() {
        winningTable = new WinningTable();
    }

    @Test
    void getMatchCountTable() {
        Assertions.assertThat(winningTable.getMatchCountTable())
                .isEqualTo(new WinningTable().getMatchCountTable());
    }

    @Test
    @DisplayName("일치하는 수의 당첨자 수를 증가시킨다.")
    void setAutoIncrementMatchCountResult() {
        winningTable.incrementMatchCountResult(3, false);
        winningTable.incrementMatchCountResult(3, false);
        Assertions.assertThat(winningTable.getMatchCountTable().get(Rank.getRank(3,false))).isEqualTo(2);
    }

    @Test
    void getTotalWinningMoney() {
        winningTable.incrementMatchCountResult(4, false);
        Assertions.assertThat(winningTable.getTotalWinningMoney()).isEqualTo(Rank.FOURTH.getWinningMoney());
    }
}