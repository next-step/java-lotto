package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @DisplayName("LottoMatch 에 따른 Rank를 구한다.")
    @MethodSource
    void createRankByLottoMatch(LottoMatch match, Rank expected) {
        assertThat(Rank.from(match)).isEqualTo(expected);
    }

    static Stream<Arguments> createRankByLottoMatch() {
        return Stream.of(
                Arguments.of(
                        LottoMatch.of(6, Boolean.FALSE), Rank.FIRST
                ),
                Arguments.of(
                        LottoMatch.of(5, Boolean.TRUE), Rank.SECOND
                ),
                Arguments.of(
                        LottoMatch.of(5, Boolean.FALSE), Rank.THIRD
                ),
                Arguments.of(
                        LottoMatch.of(4, Boolean.FALSE), Rank.FOURTH
                ),
                Arguments.of(
                        LottoMatch.of(3, Boolean.FALSE), Rank.FIFTH
                ),
                Arguments.of(
                        LottoMatch.of(0, Boolean.FALSE), Rank.NOTHING
                )
        );
    }
}