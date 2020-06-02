package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("로또 번호 util class")
class LottoNumberTest {
    @Test
    @DisplayName("로또 번호는 1부터 45까지의 수만 가능하다.")
    void valid_lotto_numbers() {
        assertThat(LottoNumber.getNumbers().size()).isEqualTo(45);
        assertThat(Collections.min(LottoNumber.getNumbers())).isEqualTo(1);
        assertThat(Collections.max(LottoNumber.getNumbers())).isEqualTo(45);
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호는 1부터 45까지의 수가 아닌 경우 IllegalArgumentException throw")
    void valid_lotto_numbers_byValidNumberRange(int lottoNumber) {
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.validNumberRange(lottoNumber));
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.validNumberRange(lottoNumber));
    }

    @Test
    @DisplayName("numbers 값은 변경 불가능한 값이어야한다.")
    void not_change_lotto_numbers() {
        List<Integer> originalNumbers = LottoNumber.getNumbers();
        originalNumbers.clear();
        List<Integer> changedNumbers = LottoNumber.getNumbers();
        assertThat(changedNumbers).isNotEmpty();
    }
}