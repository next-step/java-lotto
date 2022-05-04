package autolotto.constant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {
            "6:false:2_000_000_000",
            "5:true:30_000_000",
            "5:false:1_500_000",
            "4:false:50000",
            "3:false:5000",
            "0:false:0"
    }, delimiter = ':')
    void countOfMatchAndIsBonusGiven_ReturnRank(int countOfMatch, boolean hasBonusBall, long prize) {
        assertThat(Rank.find(countOfMatch, hasBonusBall).getWinningMoney()).isEqualTo(prize);
    }

    @Test
    void isSecond() {
        assertThat(Rank.isSecond(Rank.FIRST)).isFalse();
        assertThat(Rank.isSecond(Rank.SECOND)).isTrue();
    }

    @Test
    void valuesExceptMISS() {
        assertThat(Rank.valuesExceptMiss().size()).isEqualTo(5);
    }
}
