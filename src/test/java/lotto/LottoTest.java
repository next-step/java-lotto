package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class LottoTest {
    @Test
    @DisplayName("Lotto 는 자동번호로 자신을 생성할 수 있다.")
    void constructorMethodAuto() {
        // given
        Lotto lotto = new Lotto();

        // when

        // then
    }

    @ParameterizedTest
    @MethodSource("constructorMethodManualSource")
    @DisplayName("Lotto 는 6개의 번호를 받아 자신을 생성할 수 있다.")
    void constructorMethodManual(String numbers) {
        // given
        Lotto self = new Lotto(numbers);

        // when
        Lotto other = new Lotto(numbers);

        // then
        assertThat(self).isEqualTo(other);
    }

    static Stream<Arguments> constructorMethodManualSource() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6"),
                Arguments.of("40, 41, 42, 43, 44, 45")
        );
    }
}
