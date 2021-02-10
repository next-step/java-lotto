package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoCountTest {

    @DisplayName("잘못된 수동 로또 갯수가 입력 됬을때 처리 테스트")
    @ParameterizedTest
    @MethodSource("provideWrongManualCountTest")
    public void wrongManualCountTest(Money money, int manualCount) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new LottoCount(money, manualCount));
    }

    private static Stream<Arguments> provideWrongManualCountTest() {
        return Stream.of(
                Arguments.of(new Money("14000"), 15),
                Arguments.of(new Money("14000"), -1)
        );
    }

    @DisplayName("잘못된 수동 로또 갯수가 입력 됬을때 처리 테스트")
    @ParameterizedTest
    @MethodSource("provideCorrectManualCountTest")
    public void correctManualCountTest(Money money, int manualCount, int expected) {
        assertThat(new LottoCount(money, manualCount).calculateAutoCount()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCorrectManualCountTest() {
        return Stream.of(
                Arguments.of(new Money("14000"), 14, 0),
                Arguments.of(new Money("14000"), 0, 14),
                Arguments.of(new Money("14000"), 7, 7)
        );
    }
}
