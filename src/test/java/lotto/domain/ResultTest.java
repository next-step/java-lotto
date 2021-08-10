package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class ResultTest {

    @DisplayName("객체 생성")
    @Test
    void create() {
        assertThat(new Result(Rank.MISS, 0)).isInstanceOf(Result.class);
    }

    @DisplayName("등수별 합산금액 반환")
    @ParameterizedTest
    @CsvSource(value = {"MISS:6:0", "FIFTH:5:25000", "FOURTH:4:200000", "THIRD:3:4500000", "SECOND:2:60000000", "FIRST:1:2000000000"}, delimiter = ':')
    void totalWinningMoney_등수별_합산금액(String rankName, int hitsCount, int totalWinningMoney) {
        assertThat(new Result(Rank.valueOf(rankName), hitsCount).calculateTotalWinningMoney()).isEqualTo(totalWinningMoney);
    }

    @DisplayName("값증가 확인")
    @Test
    void addHitsCount_값증가() {
        Result result = new Result(Rank.FIFTH, 5);
        assertThat(result.calculateTotalWinningMoney()).isEqualTo(25000);
        result.addHitsCount(Rank.FIFTH);
        assertThat(result.calculateTotalWinningMoney()).isEqualTo(30000);
        result.addHitsCount(Rank.MISS);
        assertThat(result.calculateTotalWinningMoney()).isEqualTo(30000);
    }

}
