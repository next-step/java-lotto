package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WonNumbersTest {

    @Test
    @DisplayName("우승번호 객체 생성 확인")
    void newWonNumbers() {

        WonNumbers wonNumbers = new WonNumbers("1, 2, 3, 4, 5, 6", "7");
        assertThat(wonNumbers.getNormalNumbers()).containsExactly(
                WonNumber.ofNormalNumber(1),
                WonNumber.ofNormalNumber(2),
                WonNumber.ofNormalNumber(3),
                WonNumber.ofNormalNumber(4),
                WonNumber.ofNormalNumber(5),
                WonNumber.ofNormalNumber(6));

        assertThat(wonNumbers.getBonusNumber()).isEqualTo(WonNumber.ofBonusNumber(7));
    }

    @ParameterizedTest(name = "우승번호 객체 생성 시 유효하지 않다면 IllegalArgumentException 발생. [{index}] 일반번호={0}, 보너스번호={1}")
    @MethodSource
    void parseIllegalArgumentException(String wonNormalNumberValue, String wonBonusNumberValue) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WonNumbers(wonNormalNumberValue, wonBonusNumberValue));
    }

    private static Stream<Arguments> parseIllegalArgumentException() {

        return Stream.of(
                // 일반번호 null
                Arguments.of(" ", "7"),
                // 보너스번호 null
                Arguments.of(IntStream.rangeClosed(1, 6).mapToObj(String::valueOf).collect(Collectors.joining(", ")), " "),
                // 일반번호 5개
                Arguments.of(IntStream.rangeClosed(1, 5).mapToObj(String::valueOf).collect(Collectors.joining(", ")), "7"),
                // 일반번호 7개
                Arguments.of(IntStream.rangeClosed(1, 7).mapToObj(String::valueOf).collect(Collectors.joining(", ")), "7"),
                // 일반번호가 45 이상
                Arguments.of(IntStream.rangeClosed(41, 46).mapToObj(String::valueOf).collect(Collectors.joining(", ")), "7"),
                // 보너스번호가 45 이상
                Arguments.of(IntStream.rangeClosed(1, 6).mapToObj(String::valueOf).collect(Collectors.joining(", ")), "46")
        );
    }
}