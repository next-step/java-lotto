package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("생성된 로또는 사이즈가 6이다")
    void generate_lotto_size() {
        assertThat(new Lotto().numbers()).hasSize(6);
    }

    @Test
    @DisplayName("생성된 로또는 1부터 45사이의 값을 가진다")
    void generate_lotto_range() {
        assertThat(new Lotto().numbers()).allMatch(number -> number >= 1 && number <= 45);
    }
}