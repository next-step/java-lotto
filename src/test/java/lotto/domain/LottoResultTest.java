package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class LottoResultTest {

    private static Stream<Arguments> argumentsForLottoResultTest() {
        return Stream.of(
                Arguments.of(LottoResult.FIRST, 6, true, true),
                Arguments.of(LottoResult.FIRST, 6, false, true),

                Arguments.of(LottoResult.SECOND, 5, true, true),
                Arguments.of(LottoResult.SECOND, 5, false, false),

                Arguments.of(LottoResult.THIRD, 5, true, false),
                Arguments.of(LottoResult.THIRD, 5, false, true),

                Arguments.of(LottoResult.FORTH, 4, true, true),
                Arguments.of(LottoResult.FORTH, 4, false, true),

                Arguments.of(LottoResult.FIFTH, 3, true, true),
                Arguments.of(LottoResult.FIFTH, 3, false, true)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsForLottoResultTest")
    void 당첨정보(LottoResult lottoResult, int count, boolean hasBonusNumber, boolean expected) {
        assertThat(lottoResult.match(count, hasBonusNumber)).isEqualTo(expected);
    }

    @Test
    void 생성() {
        assertThat(LottoResult.from(3, false)).isEqualTo(LottoResult.FIFTH);
        assertThat(LottoResult.from(5, true)).isEqualTo(LottoResult.SECOND);
    }
}

