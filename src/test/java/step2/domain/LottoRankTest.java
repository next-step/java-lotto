package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("provideArgumentsForLottoRank")
    @DisplayName("LottoRank valueOf 테스트")
    void LottoRank_valueOf_TEST(int countOfMatch, boolean matchBonus, LottoRank expected) {
        LottoRank lottoRank = LottoRank.valueOf(countOfMatch, matchBonus);
        assertThat(lottoRank).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgumentsForLottoRank() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.ONE),
                Arguments.of(5, true, LottoRank.TWO),
                Arguments.of(5, false, LottoRank.THREE),
                Arguments.of(4, false, LottoRank.FOUR),
                Arguments.of(3, false, LottoRank.FIVE),
                Arguments.of(2, false, LottoRank.ZERO),
                Arguments.of(1, true, LottoRank.ZERO),
                Arguments.of(0, false, LottoRank.ZERO)
        );
    }
}