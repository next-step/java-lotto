package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 util class")
class LottoNumberTest {
    @Test
    @DisplayName("로또 번호는 1부터 45까지의 수만 가능하다.")
    void valid_lotto_numbers() {
        assertThat(LottoNumber.getNumbers().size()).isEqualTo(45);
        assertThat(Collections.min(LottoNumber.getNumbers())).isEqualTo(1);
        assertThat(Collections.max(LottoNumber.getNumbers())).isEqualTo(45);
    }
}