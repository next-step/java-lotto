package autolotto.constant;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {
            "5:true:30000000",
            "5:false:1500000"
    }, delimiter = ':')
    void countOfMatchAndIsBonusGiven_ReturnRank(int countOfMatch, boolean hasBonusBall, long prize) {
        assertThat(Rank.find(countOfMatch, hasBonusBall).get().getWinningMoney()).isEqualTo(prize);
    }
}
