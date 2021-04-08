package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @DisplayName("winningMoney 일치하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void getWinningMoneyTest(int value, int cash) {
        int winningMoney = Rank.valueOf(value, false).getWinningMoney();
        assertEquals(winningMoney, cash);
    }

    @DisplayName("winningMoney 일치하는지 확인 - 보너스")
    @Test
    void getWinningMoneyWithBonusNumberTest() {
        int winningMoney = Rank.valueOf(5, true).getWinningMoney();
        assertEquals(winningMoney, 30_000_000);
    }
}