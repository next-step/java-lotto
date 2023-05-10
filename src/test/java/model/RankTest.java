package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {
    @Test
    @DisplayName("당첨 규칙")
    void winRuleTest() {
        //then
        assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.getWinningMoney()).isEqualTo(1_500_000);
        assertThat(Rank.THRID.getWinningMoney()).isEqualTo(50_000);
        assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(5_000);
        assertThat(Rank.MISS.getWinningMoney()).isEqualTo(0);
    }
}
