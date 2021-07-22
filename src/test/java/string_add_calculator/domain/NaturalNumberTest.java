package string_add_calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자연수 클래스 테스트")
public class NaturalNumberTest {

    @DisplayName("자연수는 숫자 문자열을 가지고 초기화 한다.")
    @MethodSource
    @ParameterizedTest
    void initNaturalNumber(String numberString, NaturalNumber expectedNumber) {
        assertThat(NaturalNumber.of(numberString)).isEqualTo(expectedNumber);
    }

    private static Stream<Arguments> initNaturalNumber() {
        return Stream.of(
                Arguments.of("0", NaturalNumber.of("0")),
                Arguments.of("5", NaturalNumber.of("5")),
                Arguments.of("10", NaturalNumber.of("10"))
        );
    }

}
