package lotto.service.domain.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("배당표 정상 생성여부")
    void valueOf(int countOfMatch) {
        Rank rank = Rank.convertRankByCountOfMatch(countOfMatch);
        assertThat(rank).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 7, 8, 9})
    @DisplayName("잘못된 숫자 입력 시, MISS 반환")
    void valueOf_exception(int countOfMatch) {
        assertThat(Rank.convertRankByCountOfMatch(countOfMatch)).isEqualTo(Rank.MISS);
    }
}
