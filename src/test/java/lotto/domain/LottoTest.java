package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호는 6개")
    @Test
    void createTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @DisplayName("로또 번호가 6개가 아닐 경우 예외 발생")
    @Test
    void hasSixNumbersTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 중복될 경우 예외 발생")
    @Test
    void distinctNumbersTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 오름차순으로 확인")
    @Test
    void numbersAscendingTest() {
        Lotto lotto = new Lotto(List.of(10, 4, 20, 7, 34, 1));

        assertThat(lotto.getNumbers()).containsExactly(1, 4, 7, 10, 20, 34);
    }
}
