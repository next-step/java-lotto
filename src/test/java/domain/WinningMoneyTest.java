package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningMoneyTest {
    @Test
    void create() {
        //given
        Cash cash = new Cash(3000);

        //when
        WinningMoney result = new WinningMoney(cash);

        //then
        assertThat(result).isEqualTo(new WinningMoney(cash));
    }

    @Test
    void createByStaticFactoryMethod() {
        //given
        CountByRank countByRank = TestObjectSupport.createFirstCountByRank();

        //when
        WinningMoney result = WinningMoney.of(countByRank);

        //then
        assertThat(result).isEqualTo(new WinningMoney(Rank.FIRST.getWinningMoney()));
    }

    @Test
    void toRate() {
        //given
        Cash cash = new Cash(3000);
        WinningMoney winningMoney = TestObjectSupport.createFirstWinningMoney();

        //when
        BigDecimal result = winningMoney.toRate(cash);

        //then
        assertThat(result).isEqualTo(Rank.FIRST.getWinningMoney().divide(cash).toBigDecimal());
    }
}
