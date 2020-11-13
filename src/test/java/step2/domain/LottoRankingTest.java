package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoRankingTest {

    @DisplayName("로또 랭킹을 테스트 합니다.")
    @ParameterizedTest
    @MethodSource("provideLottoRank")
    void createLottoRank(int match, LottoRank lottoRank) {
        assertThat(LottoRank.matchLottoRankPrice(match)).isEqualTo(lottoRank.getPrice());
    }

    private static Stream<Arguments> provideLottoRank() {
        return Stream.of(
                Arguments.of(6, LottoRank.FIRST),
                Arguments.of(4, LottoRank.SECOND),
                Arguments.of(3, LottoRank.THIRD),
                Arguments.of(2, LottoRank.FORTH),
                Arguments.of(0, LottoRank.MISS)
        );
    }

}
