package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {

    @DisplayName("중복되지 않은 6개의 숫자 리스트를 반환한다.")
    @Test
    void randomListTest() {
        List<Integer> randomList = LottoNumbers.randomList();

        assertThat(randomList.size()).isEqualTo(6);
    }

    @DisplayName("6개의 값을 가지지 않은 객체를 전달하면 IllegalArgumentException을 던진다.")
    @Test
    void checkTest() {
        assertThatThrownBy(() -> LottoNumbers.check(Set.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumbers.check(Set.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
