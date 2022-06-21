package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningMoneyTest {
    @Test
    void create() {
        //given
        int cash = 3000;

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
        assertThat(result).isEqualTo(Rank.FIRST.getWinningMoney());
    }

    @Test
    void toRate() {
        //given
        Cash cash = new Cash(3000);
        WinningMoney winningMoney = Rank.FIRST.getWinningMoney();

        //when
        BigDecimal result = winningMoney.toRate(cash);

        //then
        assertThat(result).isEqualTo(Rank.FIRST.getWinningMoney().toCash().divide(cash));
    }

    @Test
    void toCash() {
        //given
        WinningMoney winningMoney = new WinningMoney(3000);
        Cash expectedCash = new Cash(3000);

        //when
        Cash result = winningMoney.toCash();

        //then
        assertThat(result).isEqualTo(expectedCash);
    }

    @Test
    void add() {
        //given
        WinningMoney winningMoney1 = new WinningMoney(3000);
        WinningMoney winningMoney2 = new WinningMoney(2000);
        WinningMoney expectedWinningMoney = new WinningMoney(5000);

        //when
        WinningMoney result = winningMoney1.add(winningMoney2);

        //then
        assertThat(result).isEqualTo(expectedWinningMoney);
    }

    @Test
    void multiply() {
        //given
        WinningMoney winningMoney = new WinningMoney(3000);
        WinningMoney expectedWinningMoney = new WinningMoney(9000);

        //when
        WinningMoney result = winningMoney.multiply(3);

        //then
        assertThat(result).isEqualTo(expectedWinningMoney);
    }
}
