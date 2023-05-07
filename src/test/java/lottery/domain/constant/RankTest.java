package lottery.domain.constant;

import static lottery.domain.constant.Rank.FIRST;
import static lottery.domain.constant.Rank.FOURTH;
import static lottery.domain.constant.Rank.MISS;
import static lottery.domain.constant.Rank.SECOND;
import static lottery.domain.constant.Rank.THIRD;
import static lottery.domain.constant.Rank.sortRanksByCountOfMatch;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @ParameterizedTest(name = "3 이상 6 이하의 숫자가 입력 된경우 해당하는 Rank 를 반환한다")
    @ValueSource(ints = {3, 4})
    void properCountByRankTest(int countOfMatch) {
        assertThat(Rank.getRankByCountOfMatch(countOfMatch,false)).isNotEqualTo(MISS);
    }

    @ParameterizedTest(name = "2 이하의 숫자 유입시 꽝을 나타내는 MISS 를 반환한다.")
    @ValueSource(ints = {2})
    void missCountByRankTest(int countOfMatch) {
        assertThat(Rank.getRankByCountOfMatch(countOfMatch,
                false)).isEqualTo(MISS);
    }

    @ParameterizedTest(name = "총 5개의 번호가 일치하고 보너스 번호 당첨 여부가 true 이면 2등 아닌경우 3등을 리턴한다")
    @CsvSource(value = {"SECOND:true","THIRD:false"}, delimiter = ':')
    void isSecondTest(Rank rank, boolean isWinning) {
        assertThat(Rank.getRankByCountOfMatch(5, isWinning))
                .isEqualTo(rank);
    }

    @Test
    @DisplayName("일치하는 숫자 크기에 따라 오름차순으로 배열된 상수값을 반환한다.")
    void sortTest() {
        assertThat(sortRanksByCountOfMatch())
                .containsExactly(FOURTH,THIRD,SECOND,FIRST);
    }

}