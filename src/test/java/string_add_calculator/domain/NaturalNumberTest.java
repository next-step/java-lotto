package string_add_calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자연수 클래스 테스트")
public class NaturalNumberTest {

    @DisplayName("자연수는 숫자 문자열을 가지고 초기화 한다.")
    @ValueSource(strings = {"0", "5", "10"})
    @ParameterizedTest
    void initNaturalNumber(String numberString) {
        assertThat(NaturalNumber.of(numberString).toInt()).isEqualTo(Integer.parseInt(numberString));
    }
}
