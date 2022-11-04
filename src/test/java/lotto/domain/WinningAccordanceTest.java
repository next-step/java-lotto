package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningAccordanceTest {

    private static Stream<Arguments> provideAccordance() {
        return Stream.of(
            Arguments.of(new Accordance(6, false), WinningAccordance.FIRST),
            Arguments.of(new Accordance(5, true), WinningAccordance.SECOND),
            Arguments.of(new Accordance(5, false), WinningAccordance.THIRD),
            Arguments.of(new Accordance(4, false), WinningAccordance.FOURTH),
            Arguments.of(new Accordance(3, false), WinningAccordance.FIFTH)
        );
    }

    @DisplayName("당첨 번호와 보너스 볼 일치 여부에 따른 등수 반환")
    @ParameterizedTest
    @MethodSource("provideAccordance")
    void matchSix(Accordance accordance, WinningAccordance winningAccordance) {
        WinningAccordance result = WinningAccordance.of(accordance);

        assertThat(result).isEqualTo(winningAccordance);
    }
}
