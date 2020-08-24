package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("유효 범위 내의 로또 번호 테스트")
    void valid_lotto_number_test(int number) {
        assertThatCode(() -> LottoNumber.valueOf(number))
                .doesNotThrowAnyException();
        assertThatCode(() -> LottoNumber.valueOf(number))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 50})
    @DisplayName("유효 범위 밖의 로또 번호 테스트")
    void invalid_lotto_number_test(int number) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LottoNumber lottoNumber = LottoNumber.valueOf(number);
        });
    }
}
