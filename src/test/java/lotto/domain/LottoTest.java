package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("생성된 로또는 정렬되어 있다")
    void generate_lotto_sort() {
        assertThat(new Lotto().numbers()).isSorted();
    }

    @Test
    @DisplayName("생성된 로또는 수정이 불가하다")
    void generate_lotto_immutable() {
        assertThatThrownBy(() -> new Lotto().numbers().add(5)).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("수동으로도 생성 가능하다(당첨 번호 입력)")
    void generate_lotto_passive() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).numbers()).hasSize(6);
    }
}