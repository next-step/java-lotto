package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMatcherTest {

    @ParameterizedTest
    @MethodSource("provideMatchCount")
    @DisplayName("등수 찾기 테스트")
    void findRankingTest(int count, LottoMatcher lottoMatcher) {
        LottoMatcher findLottoMatcher = LottoMatcher.findRanking(count);
        assertThat(findLottoMatcher).isEqualTo(lottoMatcher);
    }

    private static Stream<Arguments> provideMatchCount() {
        return Stream.of(
                Arguments.of(3, LottoMatcher.FOURTH_PLACE),
                Arguments.of(4, LottoMatcher.THIRD_PLACE),
                Arguments.of(5, LottoMatcher.SECOND_PLACE),
                Arguments.of(6, LottoMatcher.FIRST_PLACE)
        );
    }
}