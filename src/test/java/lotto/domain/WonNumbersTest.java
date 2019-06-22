package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WonNumbersTest {

    @Test
    @DisplayName("우승번호 객체 생성 확인")
    void newWonNumbers() {

        WonNumbers wonNumbers = new WonNumbers("1, 2, 3, 4, 5, 6");
        assertThat(wonNumbers.getWonNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest(name = "우승번호 객체 생성 시 유효하지 않다면 IllegalArgumentException 발생. wonNumbers={0}")
    @MethodSource
    @NullAndEmptySource
    void parseIllegalArgumentException(String wonNumbers) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WonNumbers(wonNumbers));
    }

    private static Stream<Arguments> parseIllegalArgumentException() {

        return Stream.of(
                Arguments.of(IntStream.rangeClosed(1, 5).mapToObj(String::valueOf).collect(Collectors.joining(", "))),
                Arguments.of(IntStream.rangeClosed(1, 7).mapToObj(String::valueOf).collect(Collectors.joining(", ")))
        );
    }
}