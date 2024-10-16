package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberSizeTest {

    @Test
    void 리스트_로또사이즈만큼_자르기_검증() {
        List<Integer> numbers = LottoNumberSize.sliceLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        assertThat(numbers).hasSize(6);
    }

    @Test
    void 사이즈가_6개_보다_작을때_예외() {
        assertThatThrownBy(
                () -> LottoNumberSize.validateSize(Set.of(1, 2, 3))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사이즈가_6개_보다_클때_예외() {
        assertThatThrownBy(
                () -> LottoNumberSize.validateSize(Set.of(1, 2, 3, 4, 5, 6, 7))
        ).isInstanceOf(IllegalArgumentException.class);
    }


}
