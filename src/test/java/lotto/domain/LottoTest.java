package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또를 생성한다.")
    void createLotto() {
        Lotto lotto = new Lotto();

        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).hasSize(6);
    }

    @Test
    @DisplayName("로또 생성 시 size 를 체크한다.")
    void createLottoValidSize() {

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("lotto number 개수는 6개입니다.");
    }

    @Test
    @DisplayName("로또 생성 시 1 과 45 사이의 숫자가 아닌지 체크한다.")
    void createLottoValidNumber() {

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 100));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("lotto number는 1과 45사이의 숫자입니다.");
    }
}
