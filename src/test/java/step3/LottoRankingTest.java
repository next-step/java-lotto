package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.LottoRank;
import step3.exception.NotMatchRankException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoRankingTest {

    @DisplayName("로또 랭킹을 테스트 합니다.")
    @ParameterizedTest
    @MethodSource("provideLottoRank")
    void createLottoRank(int match, boolean bonusMatch, LottoRank lottoRank) {
        assertThat(LottoRank.valueOf(match, bonusMatch)).isEqualTo(lottoRank);
    }

    private static Stream<Arguments> provideLottoRank() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, false, LottoRank.FORTH),
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(2, false, LottoRank.MISS),
                Arguments.of(1, false, LottoRank.MISS),
                Arguments.of(0, false, LottoRank.MISS)
        );
    }

    @DisplayName("로또 맞춘 갯수 범위를 이상하게 넣었을 경우 익셉션 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    void createLottoRank(int match) {
        assertThatThrownBy(() -> LottoRank.valueOf(match , true))
                .isInstanceOf(NotMatchRankException.class);
    }

}
