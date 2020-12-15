package step3.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static step3.domain.Rank.*;

class RankTest {

    @ParameterizedTest
    @MethodSource("generateRankData")
    @DisplayName("일치하는 개수와 보너스 존재여부로 Rank를 가져오는 테스트 ")
    void rank(int countOfMatch, boolean matchBonus, Rank expectedRank) {
        Assertions.assertEquals(Rank.valueOf(countOfMatch, matchBonus), expectedRank);
    }

    static Stream<Arguments> generateRankData() {
        return Stream.of(
                Arguments.of(FIRST.getCountOfMatch(), false, FIRST),
                Arguments.of(SECOND.getCountOfMatch(), true, SECOND),
                Arguments.of(THIRD.getCountOfMatch(), false, THIRD),
                Arguments.of(FOURTH.getCountOfMatch(), false, FOURTH),
                Arguments.of(FIFTH.getCountOfMatch(), false, FIFTH),
                Arguments.of(MISS.getCountOfMatch(), false, MISS)
        );
    }
}