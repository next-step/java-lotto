package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    static Stream<Arguments> 로또_등수_매개변수() {
        return Stream.of(
                Arguments.of(6, LottoRank.FIRST),
                Arguments.of(5, LottoRank.SECOND),
                Arguments.of(4, LottoRank.THIRD),
                Arguments.of(3, LottoRank.FOURTH),
                Arguments.of(2, LottoRank.NOT_MATCHED),
                Arguments.of(1, LottoRank.NOT_MATCHED),
                Arguments.of(0, LottoRank.NOT_MATCHED)
                // 다른 테스트 케이스도 추가할 수 있습니다.
        );
    }

    @ParameterizedTest(name = "{0}개가 일치하면 {1} 이다.")
    @MethodSource("로또_등수_매개변수")
    void 당첨_갯수로_로또_등수를_알_수_있다(int matchedCount,
                              LottoRank actual) {
        LottoRank expected = LottoRank.searchBy(matchedCount);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 입력된_수량으로_등수_금액_계산을_할_수_있다() {
        LottoRank lottoRank = LottoRank.FOURTH;

        long actual = lottoRank.calculatePrize(2);
        long expected = 10000;

        assertThat(actual).isEqualTo(expected);
    }

}
