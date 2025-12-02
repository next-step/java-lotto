package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또번호가 6개만 허용된다")
    void lotto_generate() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 6, 7)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또는 1부터 45까지의 숫자를 가진다")
    void lotto_number_limit() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 60)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("일치한 숫자만큼 count가 발생한다")
    void match() {
        assertThat(new Lotto(1, 2, 3, 4, 5, 6).match(new Lotto(1, 2, 3, 4, 5, 7))).isEqualTo(5);
    }
}