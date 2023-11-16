package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("로또번호 객체 주소가 아닌 번호 값으로 비교한다.")
    void numbers_randomly() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lottoNumbers1).isEqualTo(lottoNumbers2);
    }

    @Test
    @DisplayName("로또 번호가 중복될 시 예외를 반환한다.")
    void validate_duplicate() {
        assertThatThrownBy(() -> new LottoNumbers(List.of(1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 번호가 있습니다.");
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 시 예외를 반환한다.")
    void validate_size() {
        assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

}
