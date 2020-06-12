package dev.dahye.lotto.util;

import dev.dahye.lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("로또 번호 class")
class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    @DisplayName("로또 번호는 1부터 45까지의 수만 가능하다.")
    void valid_lotto_numbers(int number) {
        LottoNumber lottoNumber = LottoNumber.of(number);
        assertThat(lottoNumber).isNotNull();
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호는 1부터 45까지의 수가 아닌 경우 IllegalArgumentException throw")
    void valid_lotto_numbers_byValidNumberRange(int number) {
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(number));
    }
}