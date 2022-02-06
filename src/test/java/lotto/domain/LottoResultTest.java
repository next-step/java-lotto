package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource
    void enum_정상_연산_확인(int matchCount, boolean isBonusNumber) {
        LottoResult.increaseMatch(matchCount, isBonusNumber);
        assertThat(1).isEqualTo(LottoResult.findLottoResult(matchCount, isBonusNumber).getCount());
    }

    private static Stream<Arguments> enum_정상_연산_확인() {
        return Stream.of(
            Arguments.of(3, false),
            Arguments.of(4, false),
            Arguments.of(5, false),
            Arguments.of(5, true),
            Arguments.of(6, false)
        );
    }
}