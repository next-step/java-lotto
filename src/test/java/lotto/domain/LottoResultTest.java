package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class LottoResultTest {

    @ParameterizedTest
    @MethodSource("argumentsForMatchTest")
    void 당첨정보(LottoResult lottoResult, int count, boolean hasBonusNumber, boolean expected) {
        assertThat(lottoResult.match(count, hasBonusNumber)).isEqualTo(expected);
    }

    private static Stream<Arguments> argumentsForMatchTest() {
        return Stream.of(
                Arguments.of(LottoResult.FIRST, 6, true, true),
                Arguments.of(LottoResult.FIRST, 6, false, true),

                Arguments.of(LottoResult.SECOND, 5, true, true),
                Arguments.of(LottoResult.SECOND, 5, false, false),

                Arguments.of(LottoResult.THIRD, 5, false, true),
                Arguments.of(LottoResult.THIRD, 5, true, false),

                Arguments.of(LottoResult.FORTH, 4, true, true),
                Arguments.of(LottoResult.FORTH, 4, false, true),

                Arguments.of(LottoResult.FIFTH, 3, true, true),
                Arguments.of(LottoResult.FIFTH, 3, false, true),

                Arguments.of(LottoResult.NONE, 2, true, true),
                Arguments.of(LottoResult.NONE, 1, true, true),
                Arguments.of(LottoResult.NONE, 0, false, true)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsForCreateTest")
    void 생성(LottoResult lottoResult, int matchCount, boolean hasBonusNumber) {
        assertThat(LottoResult.from(matchCount, hasBonusNumber)).isEqualTo(lottoResult);
    }

    private static Stream<Arguments> argumentsForCreateTest() {
        return Stream.of(
                Arguments.of(LottoResult.FIRST, 6, true),
                Arguments.of(LottoResult.SECOND, 5, true),
                Arguments.of(LottoResult.THIRD, 5, false),
                Arguments.of(LottoResult.FORTH, 4, true),
                Arguments.of(LottoResult.FIFTH, 3, true),
                Arguments.of(LottoResult.NONE, 2, true),
                Arguments.of(LottoResult.NONE, 1, true),
                Arguments.of(LottoResult.NONE, 0, true)
        );
    }
}

