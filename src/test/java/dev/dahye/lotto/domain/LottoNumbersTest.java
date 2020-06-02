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
class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호는 1부터 45까지의 수만 가능하다.")
    void valid_lotto_numbers() {
        List<Integer> lottoNumbers = LottoNumbers.getNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(45);
        assertThat(Collections.min(lottoNumbers)).isEqualTo(1);
        assertThat(Collections.max(lottoNumbers)).isEqualTo(45);
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호는 1부터 45까지의 수가 아닌 경우 IllegalArgumentException throw")
    void valid_lotto_numbers_byValidNumberRange(int lottoNumber) {
        assertThrows(IllegalArgumentException.class, () -> LottoNumbers.validNumberRange(lottoNumber));
    }

    @Test
    @DisplayName("numbers 값은 변경 불가능한 값이어야한다.")
    void not_change_lotto_numbers() {
        List<Integer> originalNumbers = LottoNumbers.getNumbers();
        originalNumbers.clear();
        List<Integer> changedNumbers = LottoNumbers.getNumbers();
        assertThat(changedNumbers).isNotEmpty();
    }
}