package lotto_second;

import lotto_second.domain.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @ParameterizedTest(name = "{index} ===> 일치하는 번호 : {0} , 보너스볼 일치여부 : {1}, 등수 : {2} 확인")
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, MISS"
    })
    void valueOf(int countOfMatch, boolean matchBonus, Rank expected) {
        assertThat(Rank.findRank(countOfMatch, matchBonus)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index} ===> 등수 : {0} , 일치하는 번호 수 : {1} 확인")
    @CsvSource({
            "FIRST, 6",
            "SECOND, 5",
            "THIRD, 5",
            "FOURTH, 4",
            "FIFTH, 3"
    })
    void getCountOfMatch(Rank rank, int expected) {
        assertThat(rank.getCountOfMatch()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index} ===> 등수 : {0} , 상금 : {1} 확인")
    @CsvSource({
            "FIRST, 2000000000",
            "SECOND, 30000000",
            "THIRD, 1500000",
            "FOURTH, 50000",
            "FIFTH, 5000"
    })
    void getWinningMoney(Rank rank, int expected) {
        assertThat(rank.getWinningMoney()).isEqualTo(expected);
    }
}
