package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @DisplayName("맞은 갯수로 등수 조회 검증")
    @ParameterizedTest
    @MethodSource("searchRankTestArg")
    void searchRank_등수_조회(LottoRank lottoRank, int matchCount, boolean matchBonusYN) {
        assertThat(LottoRank.searchBonusRank(matchCount, matchBonusYN)).isEqualTo(lottoRank);
    }

    static Stream<Arguments> searchRankTestArg() {
        return Stream.of(
                Arguments.of(MISS, 0, false),
                Arguments.of(FIFTH, 3, false),
                Arguments.of(FOURTH, 4, false),
                Arguments.of(MISS, 0, false),
                Arguments.of(THIRD, 5, false),
                Arguments.of(SECOND, 5, true),
                Arguments.of(FIRST, 6, false)
        );
    }
}
