package lottery.domain.constant;

import static lottery.domain.constant.Rank.MISS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @ParameterizedTest(name = "3 이상 6 이하의 숫자가 입력 된경우 해당하는 Rank 를 반환한다")
    @ValueSource(ints = {3, 4})
    void properCountByRankTest(int countOfMatch) {
        assertThat(Rank.getRankByCountOfMatch(countOfMatch)).isNotEqualTo(MISS);
    }

    @ParameterizedTest(name = "2 이하의 숫자 유입시 꽝을 나타내는 MISS 를 반환한다.")
    @ValueSource(ints = {2})
    void missCountByRankTest(int countOfMatch) {
        assertThat(Rank.getRankByCountOfMatch(countOfMatch)).isEqualTo(MISS);
    }

}