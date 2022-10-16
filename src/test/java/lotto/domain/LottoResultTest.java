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
    @MethodSource("argumentsForCreateTest")
    void 생성(int matchCount, boolean hasBonusNumber, LottoResult lottoResult) {
        assertThat(LottoResult.from(matchCount, hasBonusNumber)).isEqualTo(lottoResult);
    }

    private static Stream<Arguments> argumentsForCreateTest() {
        return Stream.of(
                Arguments.of(6, true, LottoResult.FIRST),
                Arguments.of(6, false, LottoResult.FIRST),

                Arguments.of(5, true, LottoResult.SECOND),
                Arguments.of(5, false, LottoResult.THIRD),

                Arguments.of(4, true, LottoResult.FORTH),
                Arguments.of(4, false, LottoResult.FORTH),

                Arguments.of(3, true, LottoResult.FIFTH),
                Arguments.of(3, false, LottoResult.FIFTH),

                Arguments.of(2, true, LottoResult.NONE),
                Arguments.of(2, false, LottoResult.NONE),
                Arguments.of(1, false, LottoResult.NONE),
                Arguments.of(0, false, LottoResult.NONE)
        );
    }
}

