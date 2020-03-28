package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 22, 45})
    void successByCreation(int input) {
        LottoNumber lottoNumber = LottoNumber.of(input);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(input));
        assertThat(lottoNumber.getNumber()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void exceptByCreation(int input) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            LottoNumber.of(input);
        }).withMessage(String.format("%d는 1~45 숫자 사이의 번호가 아닙니다", input));
    }
}