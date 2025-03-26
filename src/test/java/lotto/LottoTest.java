package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("로또 생성하면서 숫자 정렬되는지 테스트")
    @Test
    void create_lotto() {
        assertThat(new Lotto(Arrays.asList(6,5,4,3,2,1)))
                .extracting("numbers")
                .asList()
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 번호 비교 하여 당첨 순위 반환하는 기능 테스트")
    @Test
    void compare_lotto() {
        Lotto lotto = new Lotto(Arrays.asList(6,5,4,3,2,1));
        assertThat(lotto.compareNumbers(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .isEqualTo(Division.FIRST);
        assertThat(lotto.compareNumbers(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))))
                .isEqualTo(null);
    }
}
