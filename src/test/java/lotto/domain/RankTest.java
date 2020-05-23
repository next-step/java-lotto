package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("순위를 조회한다.")
    @ParameterizedTest(name = "일치하는 갯수가 : {0}이고, 보너스 번호가 매치 : {1}, 결과는 {2}이다")
    @MethodSource("source")
    void valueOf(int countOfMatch,  boolean matchBonus, Rank expect){
        Rank actual = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(actual).isEqualTo(expect);
    }

    static Stream<Arguments> source() {
        return Stream.of(
            arguments(6,false,Rank.FIRST),
            arguments(5, true, Rank.SECOND),
            arguments(5, false, Rank.THIRD),
            arguments(4, false, Rank.FOURTH),
            arguments(4, true, Rank.FOURTH),
            arguments(3, false, Rank.FIFTH),
            arguments(3, true, Rank.FIFTH),
            arguments(2, false, Rank.MISS),
            arguments(0, false, Rank.MISS),
            arguments(0, true, Rank.MISS)
        );
    }
}
