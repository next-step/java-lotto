package lotto;

import lotto.domain.entity.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.math.BigDecimal;
import java.util.EnumSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RankTest {

    @ParameterizedTest
    @DisplayName("Rank Enum 열거 목록 확인")
    @EnumSource(Rank.class)
    public void 랭크_열거_목록_확인(Rank rankEnum) {
        assertTrue(EnumSet.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.MISS).contains(rankEnum));
    }

    @ParameterizedTest
    @DisplayName("valueOfCountWithMatchBonus() 확인")
    @CsvSource(value = {
            "6:false:2000000000",
            "5:true:30000000",
            "5:false:1500000",
            "4:false:50000",
            "3:false:5000",
            "2:false:0",
            "1:false:0",
            "0:false:0"
    }, delimiter = ':')
    public void 반환되는_랭크_확인(int countOfMatch, boolean matchBonus, BigDecimal winningMoney) {
        assertThat(Rank.valueOfCountWithMatchBonus(countOfMatch, matchBonus).winningMoney()).isEqualTo(winningMoney);
    }
}
