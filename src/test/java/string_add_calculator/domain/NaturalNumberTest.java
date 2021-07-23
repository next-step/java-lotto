package string_add_calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자연수 클래스 테스트")
public class NaturalNumberTest {

    @DisplayName("자연수는 숫자 문자열을 가지고 초기화 한다.")
    @ValueSource(strings = {"0", "5", "10"})
    @ParameterizedTest
    void initNaturalNumber(String numberString) {
        assertThat(NaturalNumber.from(numberString).toInt()).isEqualTo(Integer.parseInt(numberString));
    }

    @DisplayName("음수나 숫자가 아닌 문자열이 혹은 null 이 들어오면 RuntimeException 을 던진다.")
    @ValueSource(strings = {"-1", "n"})
    @NullAndEmptySource
    @ParameterizedTest
    void throwExceptionWhenNotNaturalNumber(String inputString) {
        assertThatThrownBy(() -> NaturalNumber.from(inputString)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("자연수 끼리 더할수 있다.")
    @MethodSource
    @ParameterizedTest
    void add(NaturalNumber naturalNumber, NaturalNumber anotherNaturalNumber, NaturalNumber expectedNaturalNumber) {
        assertThat(naturalNumber.add(anotherNaturalNumber)).isEqualTo(expectedNaturalNumber);
    }

    private static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(NaturalNumber.from("1"), NaturalNumber.from("1"), NaturalNumber.from("2")),
                Arguments.of(NaturalNumber.from("5"), NaturalNumber.from("5"), NaturalNumber.from("10"))
        );
    }
}
