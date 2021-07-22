package string_add_calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자연수 클래스 테스트")
public class NaturalNumberTest {

    @DisplayName("자연수는 숫자 문자열을 가지고 초기화 한다.")
    @ValueSource(strings = {"0", "5", "10"})
    @ParameterizedTest
    void initNaturalNumber(String numberString) {
        assertThat(NaturalNumber.of(numberString).toInt()).isEqualTo(Integer.parseInt(numberString));
    }

    @DisplayName("음수나 숫자가 아닌 문자열이 혹은 null 이 들어오면 RuntimeException 을 던진다.")
    @ValueSource(strings = {"-1", "n"})
    @NullAndEmptySource
    @ParameterizedTest
    void throwExceptionWhenNotNaturalNumber(String inputString) {
        assertThatThrownBy(() -> NaturalNumber.of(inputString)).isInstanceOf(RuntimeException.class);
    }
}
