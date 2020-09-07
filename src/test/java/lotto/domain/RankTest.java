package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("Rank 조회 테스트")
    public void test1(){
        assertThat(Rank.valueOf(Count.ZERO, false) == Rank.MISS).isTrue();
        assertThat(Rank.valueOf(Count.of(1),false) == Rank.MISS).isTrue();
        assertThat(Rank.valueOf(Count.of(2), false) == Rank.MISS).isTrue();
        assertThat(Rank.valueOf(Count.of(3), false) == Rank.FIFTH).isTrue();
        assertThat(Rank.valueOf(Count.of(4), false) == Rank.FOURTH).isTrue();
        assertThat(Rank.valueOf(Count.of(5), false) == Rank.THIRD).isTrue();
        assertThat(Rank.valueOf(Count.of(5), true) == Rank.SECOND).isTrue();
        assertThat(Rank.valueOf(Count.of(6), false) == Rank.FIRST).isTrue();
    }

    @Test
    @DisplayName("Rank 금액 테스트")
    public void test2(){
        assertThat(Rank.valueOf(Count.ZERO, false).getWinningMoney()).isEqualTo(BigDecimal.ZERO);
        assertThat(Rank.valueOf(Count.of(1), false).getWinningMoney()).isEqualTo(BigDecimal.ZERO);
        assertThat(Rank.valueOf(Count.of(2), false).getWinningMoney()).isEqualTo(BigDecimal.ZERO);
        assertThat(Rank.valueOf(Count.of(3), false).getWinningMoney()).isEqualTo(BigDecimal.valueOf(5_000));
        assertThat(Rank.valueOf(Count.of(4), false).getWinningMoney()).isEqualTo(BigDecimal.valueOf(50_000));
        assertThat(Rank.valueOf(Count.of(5), false).getWinningMoney()).isEqualTo(BigDecimal.valueOf(1_500_000));
        assertThat(Rank.valueOf(Count.of(5), true).getWinningMoney()).isEqualTo(BigDecimal.valueOf(30_000_000));
        assertThat(Rank.valueOf(Count.of(6), false).getWinningMoney()).isEqualTo(BigDecimal.valueOf(2_000_000_000));
    }
}