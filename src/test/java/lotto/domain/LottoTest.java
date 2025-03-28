package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 생성하면서 숫자 정렬되는지 테스트")
    @Test
    void create_lotto() {
        assertThat(Lotto.createManually(Arrays.asList(6,5,4,3,2,1)))
                .extracting("numbers")
                .asList()
                .containsExactly(1, 2, 3, 4, 5, 6);

        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.createManually(Arrays.asList(76, 5, 4, 3, 2, 1)));
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.createManually(Arrays.asList(7, 6, 5, 4, 3, 2, 1)));
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.createManually(Arrays.asList(5, 5, 4, 3, 2, 1)));
    }

    @DisplayName("로또 번호 비교 하여 당첨 순위 반환하는 기능 테스트")
    @Test
    void compare_lotto() {
        Lotto lotto = Lotto.createManually(Arrays.asList(6,5,4,3,2,1));
        assertThat(lotto.compareNumbers(Lotto.createManually(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .isEqualTo(Division.FIRST);
        assertThat(lotto.compareNumbers(Lotto.createManually(Arrays.asList(7, 8, 9, 10, 11, 12))))
                .isEqualTo(null);
    }
}
