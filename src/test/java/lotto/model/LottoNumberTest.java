package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("생성자에 유효한 범위의 숫자가 전달될 때 정상 처리되는지 검증")
    @Test
    void lottoNumberConstrctorTest() {
        int input = 10;
        assertThat(new LottoNumber(input).getValue()).isEqualTo(input);
    }

    @DisplayName("생성자에 유효한 범위의 숫자가 문자로 전달될 때 정상적으로 변환하는지 검증")
    @Test
    void stringLottoNumberConstructorTest() {
        assertThat(new LottoNumber("10")).isEqualTo(new LottoNumber(10));
    }

    @DisplayName("유효하지 않은 범위의 숫자가 생성자로 전달될 때 예외를 던지는지 검증")
    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 46, 50 })
    void lottoNumberConstructorTest(int input) {
        assertThatThrownBy(() -> new LottoNumber(input)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("유효하지 않은 범위의 문자열 숫자가 생성자로 전달될 때 예외를 던지는지 검증")
    @ParameterizedTest
    @ValueSource(strings = { "-1", "50" })
    void stringLottoNumberConstructorTest(String input) {
        assertThatThrownBy(() -> new LottoNumber(input)).isInstanceOf(RuntimeException.class);
    }
}
