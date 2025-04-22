import Lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("번호가 1~45 범위를 벗어나면 예외가 발생한다")
    @ParameterizedTest
    @CsvSource({"0", "46", "-1", "100"})
    void should_throw_exception_when_number_is_out_of_range(int input) {
        assertThatThrownBy(() -> LottoNumber.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 번호: " + input + "는 적절하지 않습니다. 1 ~ 45 사이의 값을 입력해 주세요.");
    }

    @DisplayName("올바른 번호는 정상적으로 생성된다")
    @Test
    void should_create_number_correctly() {
        LottoNumber lottoNumber = LottoNumber.of(10);
        assertEquals(10, lottoNumber.getNumber());
    }

    @DisplayName("같은 숫자는 동일한 객체로 인식된다")
    @Test
    void should_be_equal_if_numbers_are_same() {
        LottoNumber number1 = LottoNumber.of(5);
        LottoNumber number2 = LottoNumber.of(5);

        assertEquals(number1, number2);
        assertEquals(number1.hashCode(), number2.hashCode());
    }

    @DisplayName("다른 숫자는 서로 다른 객체로 인식된다")
    @Test
    void should_not_be_equal_if_numbers_are_different() {
        LottoNumber number1 = LottoNumber.of(5);
        LottoNumber number2 = LottoNumber.of(6);

        assertNotEquals(number1, number2);
    }

    @DisplayName("숫자의 문자열 표현이 정확히 반환된다")
    @Test
    void should_return_correct_string_representation() {
        LottoNumber number = LottoNumber.of(7);
        assertEquals("7", number.toString());
    }
}
