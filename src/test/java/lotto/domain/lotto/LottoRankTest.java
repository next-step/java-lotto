package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoRank Enum 테스트")
public class LottoRankTest {

    @DisplayName("일치하는 수를 로또 등수로 변경할 수 있다.")
    @ParameterizedTest
    @MethodSource
    void valueOf(int countOfMatch, LottoRank expected, int bonusCountOfMatch) {
        LottoRank lottoRank = LottoRank.valueOf(countOfMatch, bonusCountOfMatch);
        assertThat(lottoRank).isEqualTo(expected);
    }

    private static Stream<Arguments> valueOf() {
        return Stream.of(
                Arguments.of(0, LottoRank.MISS, 0),
                Arguments.of(1, LottoRank.MISS, 0),
                Arguments.of(2, LottoRank.MISS, 0),
                Arguments.of(3, LottoRank.FIFTH, 0),
                Arguments.of(4, LottoRank.FOURTH, 0),
                Arguments.of(5, LottoRank.THIRD, 0),
                Arguments.of(5, LottoRank.SECOND, 1),
                Arguments.of(6, LottoRank.FIRST, 0)
        );
    }
}
