package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("Rank 조회 테스트")
    public void test1(){
        assertThat(Rank.valueOf(Count.ZERO) == Rank.MISS).isTrue();
        assertThat(Rank.valueOf(Count.of(1)) == Rank.MISS).isTrue();
        assertThat(Rank.valueOf(Count.of(2)) == Rank.MISS).isTrue();
        assertThat(Rank.valueOf(Count.of(3)) == Rank.FOURTH).isTrue();
        assertThat(Rank.valueOf(Count.of(4)) == Rank.THIRD).isTrue();
        assertThat(Rank.valueOf(Count.of(5)) == Rank.SECOND).isTrue();
        assertThat(Rank.valueOf(Count.of(6)) == Rank.FIRST).isTrue();
    }

    @Test
    @DisplayName("Rank 금액 테스트")
    public void test2(){
        assertThat(Rank.valueOf(Count.ZERO).getWinningMoney()).isEqualTo(BigDecimal.ZERO);
        assertThat(Rank.valueOf(Count.of(1)).getWinningMoney()).isEqualTo(BigDecimal.ZERO);
        assertThat(Rank.valueOf(Count.of(2)).getWinningMoney()).isEqualTo(BigDecimal.ZERO);
        assertThat(Rank.valueOf(Count.of(3)).getWinningMoney()).isEqualTo(BigDecimal.valueOf(5_000));
        assertThat(Rank.valueOf(Count.of(4)).getWinningMoney()).isEqualTo(BigDecimal.valueOf(50_000));
        assertThat(Rank.valueOf(Count.of(5)).getWinningMoney()).isEqualTo(BigDecimal.valueOf(1_500_000));
        assertThat(Rank.valueOf(Count.of(6)).getWinningMoney()).isEqualTo(BigDecimal.valueOf(2_000_000_000));
    }
}