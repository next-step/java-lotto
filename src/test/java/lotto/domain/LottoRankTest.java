package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    private static Stream<Arguments> makeLottoRankData() {
        return Stream.of(
                Arguments.of(0, false, LottoRank.DROP),
                Arguments.of(1, false, LottoRank.DROP),
                Arguments.of(2, false, LottoRank.DROP),
                Arguments.of(5, false, LottoRank.SECOND),
                Arguments.of(5, true, LottoRank.SECOND_BONUS),
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(7, false, LottoRank.DROP)
        );
    }

    @DisplayName("LottoRank 생성(of 메소드) 테스트")
    @ParameterizedTest
    @MethodSource("makeLottoRankData")
    void of_test(int matchCount, boolean matchBonus, LottoRank lottoRank) {
        assertThat(LottoRank.of(matchCount, matchBonus)).isEqualTo(lottoRank);
    }
}
