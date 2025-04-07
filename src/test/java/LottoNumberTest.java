import Lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @CsvSource({"0", "46", "-1", "100"})
    void should_throw_exception_when_number_is_out_of_range(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 번호: " + input + "는 적절하지 않습니다.1 ~ 45사이의 값을 입력해 주세요.");
    }

    @Test
    void should_return_correct_number() {
        LottoNumber lottoNumber = new LottoNumber(10);
        assertEquals(10, lottoNumber.getNumber());
    }

    @Test
    void should_be_equal_if_numbers_are_same() {
        LottoNumber number1 = new LottoNumber(5);
        LottoNumber number2 = new LottoNumber(5);

        assertEquals(number1, number2);
        assertEquals(number1.hashCode(), number2.hashCode());
    }

    @Test
    void should_not_be_equal_if_numbers_are_different() {
        LottoNumber number1 = new LottoNumber(5);
        LottoNumber number2 = new LottoNumber(6);

        assertNotEquals(number1, number2);
    }

    @Test
    void should_return_correct_string_representation() {
        LottoNumber number = new LottoNumber(7);
        assertEquals("7", number.toString());
    }
}
